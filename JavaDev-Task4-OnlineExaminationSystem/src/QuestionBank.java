import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {

    public static Map<String, List<Question>> getAllQuestions() {
        Map<String, List<Question>> bank = new LinkedHashMap<>();

        bank.put("Java", javaQuestions());
        bank.put("DBMS", dbmsQuestions());
        bank.put("Data Structures", dataStructures());
        bank.put("Operating Systems", operatingSystems());
        bank.put("Computer Networks", computerNetworks());

        return bank;
    }

    private static List<Question> javaQuestions() {
        List<Question> q = new ArrayList<>();

        add(q, "Which component of Java executes bytecode?", "JDK", "JVM", "JRE", "Javadoc", 1);
        add(q, "Which keyword is used to inherit a class?", "implements", "extends", "inherits", "super", 1);
        add(q, "Which method is the entry point of a Java application?", "start()", "run()", "main()", "execute()", 2);
        add(q, "Which keyword prevents a method from being overridden?", "static", "private", "final", "const", 2);
        add(q, "Which collection does not allow duplicate elements?", "ArrayList", "LinkedList", "HashSet", "Vector", 2);
        add(q, "What is the default value of an int instance variable?", "0", "1", "null", "-1", 0);
        add(q, "Which keyword is used to create an object?", "class", "new", "this", "object", 1);
        add(q, "Which feature allows the same method name with different parameters?", "Inheritance", "Overloading", "Abstraction", "Encapsulation", 1);
        add(q, "Which keyword refers to the current object?", "super", "this", "current", "self", 1);
        add(q, "Which package contains Swing components?", "java.io", "java.net", "javax.swing", "java.util", 2);
        add(q, "Which concept hides implementation details?", "Abstraction", "Inheritance", "Compilation", "Iteration", 0);
        add(q, "Which keyword is used to handle exceptions?", "catch", "throws", "try", "Both try and catch", 3);
        add(q, "Which class is the parent of all Java classes?", "Main", "Object", "Class", "Parent", 1);
        add(q, "Which interface is commonly used to create a thread task?", "Runnable", "Serializable", "Cloneable", "Comparable", 0);
        add(q, "Which access modifier gives the widest access?", "private", "protected", "public", "default", 2);
        add(q, "What does JVM stand for?", "Java Variable Machine", "Java Virtual Machine", "Java Verified Machine", "Java Visual Machine", 1);
        add(q, "Which keyword is used when a class implements an interface?", "extends", "inherits", "implements", "interface", 2);
        add(q, "Which method compares two strings by content?", "==", "equals()", "compare()", "same()", 1);
        add(q, "Which data type stores true or false?", "int", "boolean", "char", "bit", 1);
        add(q, "Which keyword is used to call a parent class constructor?", "this", "super", "parent", "base", 1);
        add(q, "Which collection stores key-value pairs?", "List", "Set", "Map", "Queue", 2);
        add(q, "Which exception occurs when an array index is invalid?", "IOException", "NullPointerException", "ArrayIndexOutOfBoundsException", "ArithmeticException", 2);
        add(q, "Which keyword can be used to define a constant variable?", "constant", "final", "static", "fixed", 1);
        add(q, "Which Swing component is used for a single-line text input?", "JLabel", "JTextField", "JTextArea", "JPanel", 1);
        add(q, "Which layout manager arranges components in rows and columns?", "BorderLayout", "FlowLayout", "GridLayout", "CardLayout", 2);

        return q;
    }

    private static List<Question> dbmsQuestions() {
        List<Question> q = new ArrayList<>();

        add(q, "What does DBMS stand for?", "Data Backup Management System", "Database Management System", "Data Building Management System", "Database Memory System", 1);
        add(q, "Which key uniquely identifies a record in a table?", "Foreign Key", "Primary Key", "Candidate Value", "Alternate Field", 1);
        add(q, "Which SQL command is used to retrieve data?", "GET", "FETCH", "SELECT", "READ", 2);
        add(q, "Which normal form removes partial dependency?", "1NF", "2NF", "3NF", "BCNF", 1);
        add(q, "Which SQL clause is used to filter rows?", "ORDER BY", "GROUP BY", "WHERE", "HAVING", 2);
        add(q, "Which key creates a relationship between two tables?", "Primary Key", "Foreign Key", "Super Key", "Composite Key", 1);
        add(q, "Which command permanently removes a table?", "DELETE", "REMOVE", "DROP", "CLEAR", 2);
        add(q, "What is a collection of related tables called?", "Database", "Record", "Attribute", "Tuple", 0);
        add(q, "Which SQL command adds a new record?", "INSERT", "ADD", "CREATE", "APPEND", 0);
        add(q, "Which property ensures a transaction is completed fully or not at all?", "Consistency", "Atomicity", "Isolation", "Durability", 1);
        add(q, "Which SQL command modifies existing records?", "UPDATE", "CHANGE", "MODIFY", "ALTER", 0);
        add(q, "Which clause sorts query results?", "SORT", "ORDER BY", "GROUP BY", "ARRANGE", 1);
        add(q, "Which command removes selected rows?", "DROP", "DELETE", "REMOVE TABLE", "CLEAR", 1);
        add(q, "What is a row in a relational table called?", "Attribute", "Tuple", "Domain", "Key", 1);
        add(q, "What is a column in a relational table called?", "Tuple", "Record", "Attribute", "Relation", 2);
        add(q, "Which normal form removes transitive dependency?", "1NF", "2NF", "3NF", "4NF", 2);
        add(q, "Which SQL keyword removes duplicate results?", "UNIQUE", "DISTINCT", "DIFFERENT", "ONLY", 1);
        add(q, "Which command is used to create a table?", "MAKE", "CREATE TABLE", "NEW TABLE", "BUILD", 1);
        add(q, "Which constraint prevents NULL values?", "UNIQUE", "CHECK", "NOT NULL", "DEFAULT", 2);
        add(q, "Which constraint ensures values are unique?", "UNIQUE", "CHECK", "DEFAULT", "NULL", 0);
        add(q, "Which operation combines rows from two or more tables?", "JOIN", "MERGE", "LINK", "CONNECT", 0);
        add(q, "Which join returns matching rows from both tables?", "LEFT JOIN", "RIGHT JOIN", "INNER JOIN", "FULL JOIN", 2);
        add(q, "Which SQL clause groups rows with the same values?", "GROUP BY", "ORDER BY", "WHERE", "HAVING", 0);
        add(q, "Which clause filters grouped results?", "WHERE", "HAVING", "GROUP", "FILTER", 1);
        add(q, "What does SQL stand for?", "Structured Query Language", "Simple Query Logic", "System Query Language", "Structured Question Language", 0);

        return q;
    }

    private static List<Question> dataStructures() {
        List<Question> q = new ArrayList<>();

        add(q, "Which data structure follows LIFO?", "Queue", "Array", "Stack", "Graph", 2);
        add(q, "Which data structure follows FIFO?", "Stack", "Queue", "Tree", "Heap", 1);
        add(q, "What is the average time complexity of binary search?", "O(n)", "O(log n)", "O(n²)", "O(1)", 1);
        add(q, "Which data structure is commonly used for BFS?", "Stack", "Queue", "Heap", "Array", 1);
        add(q, "Which data structure is commonly used for DFS?", "Queue", "Stack", "Hash Table", "Heap", 1);
        add(q, "Which structure stores elements in parent-child relationships?", "Tree", "Stack", "Queue", "Array", 0);
        add(q, "Which sorting algorithm has average O(n log n) time?", "Bubble Sort", "Selection Sort", "Merge Sort", "Linear Search", 2);
        add(q, "Which structure stores nodes connected by references?", "Linked List", "Array", "Matrix", "String", 0);
        add(q, "Which data structure is used to implement recursion?", "Queue", "Stack", "Heap", "Graph", 1);
        add(q, "A binary tree node can have at most how many children?", "1", "2", "3", "4", 1);
        add(q, "Which structure is best for direct index-based access?", "Array", "Stack", "Queue", "Tree", 0);
        add(q, "What is the worst-case time complexity of linear search?", "O(1)", "O(log n)", "O(n)", "O(n log n)", 2);
        add(q, "Which data structure is commonly used for priority scheduling?", "Stack", "Priority Queue", "Linked List", "Array", 1);
        add(q, "Which traversal visits root between left and right subtrees?", "Preorder", "Inorder", "Postorder", "Level order", 1);
        add(q, "Which traversal visits root before its children?", "Preorder", "Inorder", "Postorder", "Reverse", 0);
        add(q, "Which traversal visits root after its children?", "Preorder", "Inorder", "Postorder", "Level order", 2);
        add(q, "Which data structure is used in a hash table?", "Hashing", "Stack", "Queue", "Tree only", 0);
        add(q, "What is the root node of a tree?", "A leaf", "The topmost node", "The last node", "Any middle node", 1);
        add(q, "Which structure can represent connections between cities?", "Graph", "Stack", "Queue", "Array only", 0);
        add(q, "Which sorting algorithm repeatedly swaps adjacent elements?", "Merge Sort", "Bubble Sort", "Heap Sort", "Quick Sort", 1);
        add(q, "Which algorithm uses divide and conquer?", "Merge Sort", "Linear Search", "Bubble Sort", "Selection Sort", 0);
        add(q, "What is the first index of a Java array?", "0", "1", "-1", "Depends on array", 0);
        add(q, "Which data structure allows insertion and deletion at both ends?", "Deque", "Stack only", "Tree", "Heap", 0);
        add(q, "Which data structure is generally used to model hierarchical data?", "Tree", "Queue", "Stack", "Array", 0);
        add(q, "What is a node with no children called?", "Root", "Parent", "Leaf", "Branch", 2);

        return q;
    }

    private static List<Question> operatingSystems() {
        List<Question> q = new ArrayList<>();

        add(q, "Which component manages processes and hardware resources?", "Compiler", "Operating System", "Database", "Browser", 1);
        add(q, "Which scheduling algorithm gives each process a fixed time slice?", "FCFS", "Round Robin", "SJF", "Priority", 1);
        add(q, "What is virtual memory?", "Extra CPU", "Disk space used as an extension of RAM", "A cache register", "A network drive", 1);
        add(q, "Which condition is necessary for deadlock?", "Circular Wait", "Fast CPU", "Large Memory", "High Bandwidth", 0);
        add(q, "Which memory is closest to the CPU?", "Hard Disk", "RAM", "Cache", "DVD", 2);
        add(q, "A process waiting for CPU time is generally in which state?", "Running", "Ready", "Terminated", "New", 1);
        add(q, "What does CPU stand for?", "Central Processing Unit", "Computer Processing Utility", "Central Program Unit", "Control Processing Unit", 0);
        add(q, "Which technique divides memory into fixed-size blocks?", "Paging", "Spooling", "Polling", "Buffering", 0);
        add(q, "Which type of OS supports multiple users?", "Single-user OS", "Multi-user OS", "Embedded OS", "Batch-only OS", 1);
        add(q, "Which is an example of an operating system?", "MySQL", "Linux", "HTML", "Java", 1);
        add(q, "Which scheduling algorithm selects the shortest burst first?", "SJF", "FCFS", "Round Robin", "FIFO", 0);
        add(q, "What is a process?", "A program in execution", "A file only", "A hardware device", "A compiler", 0);
        add(q, "Which memory management technique uses variable-sized partitions?", "Segmentation", "Paging", "Spooling", "Caching", 0);
        add(q, "Which is a non-preemptive scheduling algorithm?", "FCFS", "Round Robin", "Preemptive Priority", "Multilevel Feedback", 0);
        add(q, "What is a context switch?", "Switching between processes", "Changing the operating system", "Restarting RAM", "Formatting disk", 0);
        add(q, "Which component controls access to hardware?", "Kernel", "Browser", "Editor", "Database", 0);
        add(q, "Which deadlock condition means a resource cannot be shared?", "Mutual Exclusion", "Circular Wait", "Hold and Wait", "Preemption", 0);
        add(q, "Which deadlock condition means a process holds one resource while waiting for another?", "Mutual Exclusion", "Hold and Wait", "No Preemption", "Circular Wait", 1);
        add(q, "Which OS technique keeps several programs in memory?", "Multiprogramming", "Formatting", "Compiling", "Encryption", 0);
        add(q, "Which system call creates a new process in Unix-like systems?", "fork()", "start()", "newProcess()", "create()", 0);
        add(q, "What is thrashing?", "Excessive paging", "CPU overheating", "Disk formatting", "Network congestion", 0);
        add(q, "Which scheduling method is suitable for time-sharing systems?", "Round Robin", "FCFS only", "SJF only", "FIFO", 0);
        add(q, "What is starvation?", "Indefinite waiting for a resource", "Process termination", "Memory deletion", "CPU failure", 0);
        add(q, "Which memory is volatile?", "RAM", "ROM", "Hard Disk", "SSD", 0);
        add(q, "Which layer handles system calls and core resource management?", "Kernel", "Application", "Browser", "Shell script", 0);

        return q;
    }

    private static List<Question> computerNetworks() {
        List<Question> q = new ArrayList<>();

        add(q, "What does IP stand for?", "Internet Protocol", "Internal Program", "Internet Process", "Input Protocol", 0);
        add(q, "Which device forwards packets between networks?", "Switch", "Router", "Keyboard", "Repeater", 1);
        add(q, "Which protocol is commonly used for web pages?", "HTTP", "FTP", "SMTP", "SSH", 0);
        add(q, "Which OSI layer is responsible for routing?", "Physical", "Data Link", "Network", "Application", 2);
        add(q, "What does LAN stand for?", "Large Area Network", "Local Area Network", "Linked Access Network", "Local Application Network", 1);
        add(q, "Which protocol is used to send email?", "SMTP", "HTTP", "DNS", "DHCP", 0);
        add(q, "Which protocol translates domain names into IP addresses?", "FTP", "DNS", "TCP", "ARP", 1);
        add(q, "Which protocol provides reliable connection-oriented communication?", "UDP", "IP", "TCP", "ICMP", 2);
        add(q, "Which device connects devices within a LAN?", "Switch", "Router", "Modem", "Firewall", 0);
        add(q, "What does URL stand for?", "Uniform Resource Locator", "Universal Routing Link", "Uniform Response Link", "User Resource Locator", 0);
        add(q, "Which protocol is connectionless?", "TCP", "UDP", "HTTP", "FTP", 1);
        add(q, "Which OSI layer handles MAC addresses?", "Physical", "Data Link", "Network", "Transport", 1);
        add(q, "Which protocol automatically assigns IP addresses?", "DNS", "DHCP", "HTTP", "FTP", 1);
        add(q, "What is the default port of HTTP?", "21", "25", "80", "443", 2);
        add(q, "What is the default port of HTTPS?", "80", "110", "443", "8080", 2);
        add(q, "Which device repeats a signal?", "Router", "Repeater", "Switch", "Gateway", 1);
        add(q, "Which topology connects all devices to a central device?", "Bus", "Ring", "Star", "Mesh", 2);
        add(q, "Which topology has a single main communication line?", "Bus", "Star", "Ring", "Tree", 0);
        add(q, "Which protocol is used to transfer files?", "FTP", "SMTP", "DNS", "ARP", 0);
        add(q, "Which address identifies a network interface at the data link layer?", "IP address", "MAC address", "URL", "Port", 1);
        add(q, "Which layer provides end-to-end delivery in the OSI model?", "Transport", "Network", "Session", "Physical", 0);
        add(q, "What is bandwidth?", "Data carrying capacity", "Device address", "Network password", "Packet name", 0);
        add(q, "Which protocol maps an IP address to a MAC address?", "ARP", "DNS", "DHCP", "SMTP", 0);
        add(q, "What does WAN stand for?", "Wide Area Network", "Wireless Access Network", "Web Area Node", "Wide Application Network", 0);
        add(q, "Which network device can filter traffic based on security rules?", "Firewall", "Keyboard", "Repeater", "Hub", 0);

        return q;
    }

    private static void add(List<Question> list, String text,
                            String a, String b, String c, String d,
                            int correct) {
        list.add(new Question(
                text,
                new String[]{a, b, c, d},
                correct
        ));
    }
}
