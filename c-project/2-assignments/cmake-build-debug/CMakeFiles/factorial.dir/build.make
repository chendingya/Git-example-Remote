# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2021.2.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2021.2.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = E:\c-project\2-assignments

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\c-project\2-assignments\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/factorial.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/factorial.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/factorial.dir/flags.make

CMakeFiles/factorial.dir/factorial.obj: CMakeFiles/factorial.dir/flags.make
CMakeFiles/factorial.dir/factorial.obj: ../factorial.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\c-project\2-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/factorial.dir/factorial.obj"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\factorial.dir\factorial.obj -c E:\c-project\2-assignments\factorial.c

CMakeFiles/factorial.dir/factorial.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/factorial.dir/factorial.i"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\c-project\2-assignments\factorial.c > CMakeFiles\factorial.dir\factorial.i

CMakeFiles/factorial.dir/factorial.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/factorial.dir/factorial.s"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\c-project\2-assignments\factorial.c -o CMakeFiles\factorial.dir\factorial.s

# Object files for target factorial
factorial_OBJECTS = \
"CMakeFiles/factorial.dir/factorial.obj"

# External object files for target factorial
factorial_EXTERNAL_OBJECTS =

factorial.exe: CMakeFiles/factorial.dir/factorial.obj
factorial.exe: CMakeFiles/factorial.dir/build.make
factorial.exe: CMakeFiles/factorial.dir/linklibs.rsp
factorial.exe: CMakeFiles/factorial.dir/objects1.rsp
factorial.exe: CMakeFiles/factorial.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\c-project\2-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable factorial.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\factorial.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/factorial.dir/build: factorial.exe
.PHONY : CMakeFiles/factorial.dir/build

CMakeFiles/factorial.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\factorial.dir\cmake_clean.cmake
.PHONY : CMakeFiles/factorial.dir/clean

CMakeFiles/factorial.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\c-project\2-assignments E:\c-project\2-assignments E:\c-project\2-assignments\cmake-build-debug E:\c-project\2-assignments\cmake-build-debug E:\c-project\2-assignments\cmake-build-debug\CMakeFiles\factorial.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/factorial.dir/depend

