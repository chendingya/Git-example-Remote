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
CMAKE_SOURCE_DIR = E:\c-project\7-assignments

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\c-project\7-assignments\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/perspective.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/perspective.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/perspective.dir/flags.make

CMakeFiles/perspective.dir/perspective.c.obj: CMakeFiles/perspective.dir/flags.make
CMakeFiles/perspective.dir/perspective.c.obj: ../perspective.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\c-project\7-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/perspective.dir/perspective.c.obj"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\perspective.dir\perspective.c.obj -c E:\c-project\7-assignments\perspective.c

CMakeFiles/perspective.dir/perspective.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/perspective.dir/perspective.c.i"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\c-project\7-assignments\perspective.c > CMakeFiles\perspective.dir\perspective.c.i

CMakeFiles/perspective.dir/perspective.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/perspective.dir/perspective.c.s"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\c-project\7-assignments\perspective.c -o CMakeFiles\perspective.dir\perspective.c.s

# Object files for target perspective
perspective_OBJECTS = \
"CMakeFiles/perspective.dir/perspective.c.obj"

# External object files for target perspective
perspective_EXTERNAL_OBJECTS =

perspective.exe: CMakeFiles/perspective.dir/perspective.c.obj
perspective.exe: CMakeFiles/perspective.dir/build.make
perspective.exe: CMakeFiles/perspective.dir/linklibs.rsp
perspective.exe: CMakeFiles/perspective.dir/objects1.rsp
perspective.exe: CMakeFiles/perspective.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\c-project\7-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable perspective.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\perspective.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/perspective.dir/build: perspective.exe
.PHONY : CMakeFiles/perspective.dir/build

CMakeFiles/perspective.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\perspective.dir\cmake_clean.cmake
.PHONY : CMakeFiles/perspective.dir/clean

CMakeFiles/perspective.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\c-project\7-assignments E:\c-project\7-assignments E:\c-project\7-assignments\cmake-build-debug E:\c-project\7-assignments\cmake-build-debug E:\c-project\7-assignments\cmake-build-debug\CMakeFiles\perspective.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/perspective.dir/depend

