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
CMAKE_SOURCE_DIR = E:\c-project

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\c-project\cmake-build-debug

# Include any dependencies generated for this target.
include 5-assignments/CMakeFiles/radix.dir/depend.make
# Include the progress variables for this target.
include 5-assignments/CMakeFiles/radix.dir/progress.make

# Include the compile flags for this target's objects.
include 5-assignments/CMakeFiles/radix.dir/flags.make

5-assignments/CMakeFiles/radix.dir/radix.c.obj: 5-assignments/CMakeFiles/radix.dir/flags.make
5-assignments/CMakeFiles/radix.dir/radix.c.obj: ../5-assignments/radix.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\c-project\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object 5-assignments/CMakeFiles/radix.dir/radix.c.obj"
	cd /d E:\c-project\cmake-build-debug\5-assignments && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\radix.dir\radix.c.obj -c E:\c-project\5-assignments\radix.c

5-assignments/CMakeFiles/radix.dir/radix.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/radix.dir/radix.c.i"
	cd /d E:\c-project\cmake-build-debug\5-assignments && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\c-project\5-assignments\radix.c > CMakeFiles\radix.dir\radix.c.i

5-assignments/CMakeFiles/radix.dir/radix.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/radix.dir/radix.c.s"
	cd /d E:\c-project\cmake-build-debug\5-assignments && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\c-project\5-assignments\radix.c -o CMakeFiles\radix.dir\radix.c.s

# Object files for target radix
radix_OBJECTS = \
"CMakeFiles/radix.dir/radix.c.obj"

# External object files for target radix
radix_EXTERNAL_OBJECTS =

5-assignments/radix.exe: 5-assignments/CMakeFiles/radix.dir/radix.c.obj
5-assignments/radix.exe: 5-assignments/CMakeFiles/radix.dir/build.make
5-assignments/radix.exe: 5-assignments/CMakeFiles/radix.dir/linklibs.rsp
5-assignments/radix.exe: 5-assignments/CMakeFiles/radix.dir/objects1.rsp
5-assignments/radix.exe: 5-assignments/CMakeFiles/radix.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\c-project\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable radix.exe"
	cd /d E:\c-project\cmake-build-debug\5-assignments && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\radix.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
5-assignments/CMakeFiles/radix.dir/build: 5-assignments/radix.exe
.PHONY : 5-assignments/CMakeFiles/radix.dir/build

5-assignments/CMakeFiles/radix.dir/clean:
	cd /d E:\c-project\cmake-build-debug\5-assignments && $(CMAKE_COMMAND) -P CMakeFiles\radix.dir\cmake_clean.cmake
.PHONY : 5-assignments/CMakeFiles/radix.dir/clean

5-assignments/CMakeFiles/radix.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\c-project E:\c-project\5-assignments E:\c-project\cmake-build-debug E:\c-project\cmake-build-debug\5-assignments E:\c-project\cmake-build-debug\5-assignments\CMakeFiles\radix.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : 5-assignments/CMakeFiles/radix.dir/depend
