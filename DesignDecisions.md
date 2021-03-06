## Design Decisions

I chose to use a factory class to generate commands dynamically. This relies on an internal hashtable inside the CommandFactory class. This relies on the use of Java reflection to dynamically instantiate command objects at runtime.

The obvious benefit to this is the ease of adding on extra commands at a later point without having to modify many different locations in the code.

Below is an example of adding on a such a command

#### Adding an exit command

The command will allow a user to type "exit" to quit the game.

##### Generating command class

Generate ExitCommand class of abstract Command superclass

![ExitCommand](image/exitcommandgenerate.png)

Add implementation for methods of derived ExitCommand class

![WriteExitClass](image/writeexitclass.png)

Add ExitCommand to CommandFactory hashtable

![AddExitTotable](image/addexittotable.png)

As we can see this greatly simplifies additional command implementation 