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
CMAKE_SOURCE_DIR = E:\c-project\6-assignments

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\c-project\6-assignments\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/triangle.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/triangle.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/triangle.dir/flags.make

CMakeFiles/triangle.dir/triangle.c.obj: CMakeFiles/triangle.dir/flags.make
CMakeFiles/triangle.dir/triangle.c.obj: ../triangle.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\c-project\6-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/triangle.dir/triangle.c.obj"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\triangle.dir\triangle.c.obj -c E:\c-project\6-assignments\triangle.c

CMakeFiles/triangle.dir/triangle.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/triangle.dir/triangle.c.i"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\c-project\6-assignments\triangle.c > CMakeFiles\triangle.dir\triangle.c.i

CMakeFiles/triangle.dir/triangle.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/triangle.dir/triangle.c.s"
	E:\c\mingw\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\c-project\6-assignments\triangle.c -o CMakeFiles\triangle.dir\triangle.c.s

# Object files for target triangle
triangle_OBJECTS = \
"CMakeFiles/triangle.dir/triangle.c.obj"

# External object files for target triangle
triangle_EXTERNAL_OBJECTS =

triangle.exe: CMakeFiles/triangle.dir/triangle.c.obj
triangle.exe: CMakeFiles/triangle.dir/build.make
triangle.exe: CMakeFiles/triangle.dir/linklibs.rsp
triangle.exe: CMakeFiles/triangle.dir/objects1.rsp
triangle.exe: CMakeFiles/triangle.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\c-project\6-assignments\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable triangle.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\triangle.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/triangle.dir/build: triangle.exe
.PHONY : CMakeFiles/triangle.dir/build

CMakeFiles/triangle.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\triangle.dir\cmake_clean.cmake
.PHONY : CMakeFiles/triangle.dir/clean

CMakeFiles/triangle.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\c-project\6-assignments E:\c-project\6-assignments E:\c-project\6-assignments\cmake-build-debug E:\c-project\6-assignments\cmake-build-debug E:\c-project\6-assignments\cmake-build-debug\CMakeFiles\triangle.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/triangle.dir/depend

