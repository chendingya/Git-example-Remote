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
include jj-1/CMakeFiles/rotate.dir/depend.make
# Include the progress variables for this target.
include jj-1/CMakeFiles/rotate.dir/progress.make

# Include the compile flags for this target's objects.
include jj-1/CMakeFiles/rotate.dir/flags.make

jj-1/CMakeFiles/rotate.dir/rotate.c.obj: jj-1/CMakeFiles/rotate.dir/flags.make
jj-1/CMakeFiles/rotate.dir/rotate.c.obj: ../jj-1/rotate.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\c-project\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object jj-1/CMakeFiles/rotate.dir/rotate.c.obj"
	cd /d E:\c-project\cmake-build-debug\jj-1 && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\rotate.dir\rotate.c.obj -c E:\c-project\jj-1\rotate.c

jj-1/CMakeFiles/rotate.dir/rotate.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/rotate.dir/rotate.c.i"
	cd /d E:\c-project\cmake-build-debug\jj-1 && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\c-project\jj-1\rotate.c > CMakeFiles\rotate.dir\rotate.c.i

jj-1/CMakeFiles/rotate.dir/rotate.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/rotate.dir/rotate.c.s"
	cd /d E:\c-project\cmake-build-debug\jj-1 && E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\c-project\jj-1\rotate.c -o CMakeFiles\rotate.dir\rotate.c.s

# Object files for target rotate
rotate_OBJECTS = \
"CMakeFiles/rotate.dir/rotate.c.obj"

# External object files for target rotate
rotate_EXTERNAL_OBJECTS =

jj-1/rotate.exe: jj-1/CMakeFiles/rotate.dir/rotate.c.obj
jj-1/rotate.exe: jj-1/CMakeFiles/rotate.dir/build.make
jj-1/rotate.exe: jj-1/CMakeFiles/rotate.dir/linklibs.rsp
jj-1/rotate.exe: jj-1/CMakeFiles/rotate.dir/objects1.rsp
jj-1/rotate.exe: jj-1/CMakeFiles/rotate.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\c-project\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable rotate.exe"
	cd /d E:\c-project\cmake-build-debug\jj-1 && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\rotate.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
jj-1/CMakeFiles/rotate.dir/build: jj-1/rotate.exe
.PHONY : jj-1/CMakeFiles/rotate.dir/build

jj-1/CMakeFiles/rotate.dir/clean:
	cd /d E:\c-project\cmake-build-debug\jj-1 && $(CMAKE_COMMAND) -P CMakeFiles\rotate.dir\cmake_clean.cmake
.PHONY : jj-1/CMakeFiles/rotate.dir/clean

jj-1/CMakeFiles/rotate.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\c-project E:\c-project\jj-1 E:\c-project\cmake-build-debug E:\c-project\cmake-build-debug\jj-1 E:\c-project\cmake-build-debug\jj-1\CMakeFiles\rotate.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : jj-1/CMakeFiles/rotate.dir/depend

