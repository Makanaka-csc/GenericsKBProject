# Compiler and other tools
JAVAC = javac
JAR = jar
JAVADOC = javadoc

# Directories for source code, compiled classes, and documentation
src_dir = src
bin_dir = bin
doc_dir = doc

# List of Java source files to be compiled
CLASSES = $(src_dir)/Statement.java \
          $(src_dir)/KnowledgeBase.java \
          $(src_dir)/KnowledgeBaseBST.java \
          $(src_dir)/TextMenu.java \
          $(src_dir)/BinarySearchTree.java \
          $(src_dir)/BinaryTreeNode.java \
          $(src_dir)/BinaryTree.java

# Suffix for .java to .class compilation
.SUFFIXES: .java .class

# Default target
default: compile

# Compile all the files
all: compile

# Compile the Java files
compile:
	$(JAVAC) -d $(bin_dir) $(CLASSES)

# Create JAR file
jar:
	$(JAR) cf $(bin_dir)/MyProject.jar -C $(bin_dir) .

# Clean up compiled files
clean:
	rm -f $(bin_dir)/*.class $(bin_dir)/*.jar

# Generate Javadoc
javadoc:
	$(JAVADOC) -d $(doc_dir) $(src_dir)/*.java

