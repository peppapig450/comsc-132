#!/usr/bin/env bash
# This script utilizes git archive to do what Export Project in NetBeans does.
# This allows us to generate project zips from VS code and just open and test the zip in
# NetBeans before submitting an assignment.
set -Eeuo pipefail

usage() {
  cat << WHO_NEEDS_NETBEANS
Usage: $0 [-o output.zip] [-d subdir]

-o  Output zip path (default: project.zip)
-d  Directory to archive
-h  Show this help
WHO_NEEDS_NETBEANS
}

_require_arg() {
  local option="$1"
  local arg="$2"

  if [[ -z ${arg} || ${arg} =~ ^= ]]; then
    printf "Error: $%s requires an argument.\n" "$option" >&2
    usage
    exit 2
  fi
}

set_opt() {
  local -n target_ref="$1"
  local option="$2"
  local arg="$3"

  _require_arg "$option" "$arg"
  target_ref="$arg"
}

# Check if we are in the root directory of the git repo or not
check_if_git_root() {
  local repo_root
  local real_pwd

  repo_root="$(git rev-parse --show-toplevel 2> /dev/null || echo "")"

  # Get the absolute PWD, resolving symlinks
  real_pwd="$(pwd -P)"

  if [[ ${real_pwd} == "${repo_root}" ]]; then
    return 0
  else
    printf "Please run from the root of the repository.\n" >&2
    return 1
  fi
}

# Export zip using git archive
create_project_zip() {
  local output_file="${1:-}"
  local directory_path="${2:-}"

  if [[ -z ${output_file} ]]; then
    printf "Error: output file required.\n" >&2
    return 2
  fi

  if [[ -z ${directory_path} ]]; then
    printf "Error: directory path to archive is required.\n" >&2
    return 2
  fi

  mkdir -p -- "$(dirname -- "$output_file")"

  local -a archive_args=(
    archive
    --format=zip
    -o "$output_file"
    HEAD
    "$directory_path"
  )

  git "${archive_args[@]}"
}

main() {
  local output_file="project.zip"
  local directory_path

  while (($# > 0)); do
    case "$1" in
      -o | --output)
        set_opt output_file "$1" "$2"
        shift 2
        ;;
      -d | --dir)
        set_opt directory_path "$1" "$2"
        shift 2
        ;;
      -h | --help)
        usage
        exit 0
        ;;
      --)
        shift
        break
        ;;
      -*)
        printf "Invalid option: %s\n" "$1" >&2
        exit 2
        ;;
      *) break ;;
    esac
  done

  # Enforce running from repo root
  check_if_git_root || exit 1

  # Create the archive
  create_project_zip "$output_file" "$directory_path"

  printf "Success! Wrote archive: %s\n" "$output_file"
}

# Only run main if not sourced
if ! (return 0 2> /dev/null); then
  main "$@"
fi
