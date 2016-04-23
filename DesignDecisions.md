## Design Decisions

I chose to use a factory class to generate commands dynamically. This relies on and internal hashtable inside the CommandFactory class. This relies on the use of Java reflection to dynamically instantiate command objects at runtime.

The obvious benefit to this is the ease of adding on extra commands at a later point without having to modify many different locations in the code.

Below is an example of adding on a such a command

#### Adding an exit command

The command will allow a user to type "exit" to quit the game.

##### Generating command class

Generate ExitCommand class of abstract Command superclass

![ExitCommand](images/exitcommandgenerate.jpg)

Add implementation for methods of derived ExitCommand class

![WriteExitClass](images/writeexitclass.jpg)

Add ExitCommand to CommandFactory hashtable

![AddExitTotable](images/addexittotable.jpg)

As we can see this greatly simplifies additional command implementation 