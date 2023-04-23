import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Library {
    /*there are 4 sub with 15 books each ; 50 max member, can issue 1 books max and reserve 1 book at a time
      every day will cost 3.5 ruppee after 10 days*/
    String[][] b = {{"ELECTROSTATICS", "CURRENT ELECTRICITY", "MAGNETIC EFFECTS OF CURRENT AND MAGNETISM", "ELECTROMAGNETIC INDUCTION", "ALTERNATING CURRENTS", "ELECTROMAGNETIC WAVES", "OPTICS", "DUAL NATURE OF RADIATION AND MATTER", "ATOM AND NUCLEI", "ELECTRONIC DEVICES", "COMMUNICATION SYSTEMS", "GRAVITATION", "KINEMATICS", "LAWS OF MOTION", "FLUIDS"},//all books
            {"SOLID STATE", "SOLUTIONS", "ELECTROCHEMISTRY", "CHEMICAL KINETICS", "SURFACE CHEMISTRY", "P-BLOCK ELEMENTS", "D- AND F-BLOCK ELEMENTS", "COORDINATION COMPOUNDS", "HALOALKANES AND HALOARENES", "ALCOHOLS,PHENOL AND ETHERS", "ALDEHYDES,KETONES AND CARBOXYLIC ACIDS", "BIOMOLECULES", "POLYMERS", "CHEMISTRY IN EVERYDAY LIFE", "ATOMIC STRUCTURES"},
            {"RELATION AND FUNCTION", "INVERSE TRIGNOMETRIC FUNCTIONS", "TRIGNOMETRY", "DETERMINENTS", "MATRIX", "LIMITS", "PROBABILITY", "THREE DIMENSIONAL GEOMETRY", "AREA UNDER CURVE", "INTEGRATION", "DIFFERENTIATION", "APPLICATION OF DERIVATIVES", "LINEAR PROGRAMMING", "LINEAR REGRESSION", "COMPLEX NUMBERS"},
            {"CANDIDA", "MERCHANT OF VENICE", "THE TEMPEST", "YOU CAN WIN", "JOHN BROWN", "SALVATORE", "FRITZ", "QUALITY", "THE STORY OF AN HOUR", "THE CHINESE STATUE", "TO BUILD A FIRE", "THE SINGING LESSONS", "B.WORDSWORTH", "THE SOUND MACHINE", "A GORILLA IN A GUESTROOM"}};
    int[][] r = new int[4][15];//reserved books
    String[][] m = new String[50][4];//member accounts
    int[] mb = new int[50];//books issued
    int last_i, iss, i, j, mbr, per, f, l, ji, f1, day, ein;
    double fine;
    String choice, m1, t, t1, c, est;
    char ch, ech;

    Library()//constructor
    {
        ein = -1;
        ech = ' ';
        est = " ";
        ji = 0;
        iss = -1;
        f1 = 0;
        day = 0;
        t = " ";
        t1 = " ";
        choice = " ";
        last_i = -1;//total or last member
        mbr = -1;//user no.(row)
        fine = 0.0;
        per = 0;
    }

    void initials() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 15; j++) {
                r[i][j] = -1;
            }
        }
        for (i = 0; i < 50; i++) {
            for (j = 0; j < 4; j++) {
                m[i][j] = " ";
            }
        }
        for (i = 0; i < 50; i++) {
            mb[i] = -1;
        }
    }

    //as a member
    void identity() throws IOException//already a member  identify member
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name");
        m1 = br.readLine();
        for (i = 0; i < 50; i++) {
            if (m[i][0].equalsIgnoreCase(m1)) {
                mbr = i;
                System.out.println(" you are member of this library");
                per = 1;//yes he/she is a member
            }
        }
        if (per != 1)
            System.out.println("you are not member of this library");
    }

    void search_book() throws IOException//search book
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Search book by its... \na. Title\nb. Subject\nc. Show Full List...");
        ch = (char) br.read();
        if (ch == 'a') {
            System.out.println("Enter few letters of title:");
            est = br.readLine();
            t = br.readLine();
            l = t.length();
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 15; j++) {
                    b[i][j] = b[i][j] + "                                     ";
                    t1 = b[i][j].substring(0, l);
                    if (t.equalsIgnoreCase(t1)) {
                        ji = 1;
                        System.out.println("\n" + (i * 100 + j) + ". " + b[i][j]);
                    }
                    b[i][j] = b[i][j].trim();
                }
            }
            if (ji == 1) {
                System.out.println("book is found");
                System.out.println("Enter index of book to be chosen");
                iss = Integer.parseInt(br.readLine());
            } else
                System.out.println("book is not found");
        }
        if (ch == 'b') {
            System.out.println("Subjects are Physics,Chemistry,Mathematics,Stories\nEnter Subject of book to be searched");
            est = br.readLine();
            c = br.readLine();
            if (c.equalsIgnoreCase("physics")) {
                System.out.println("Books are as follows :");
                for (j = 0; j < 15; j++) {
                    System.out.println("\n" + (0 * 100 + j) + ". " + b[0][j]);
                }
            }
            if (c.equalsIgnoreCase("chemistry")) {
                System.out.println("Books are as follows :");
                for (j = 0; j < 15; j++) {
                    System.out.println("\n" + (1 * 100 + j) + ". " + b[1][j]);
                }
            }
            if (c.equalsIgnoreCase("mathematics")) {
                System.out.println("Books are as follows :");
                for (j = 0; j < 15; j++) {
                    System.out.println("\n" + (2 * 100 + j) + ". " + b[2][j]);
                }
            }
            if (c.equalsIgnoreCase("stories")) {
                System.out.println("Books are as follows :");
                for (j = 0; j < 15; j++) {
                    System.out.println("\n" + (3 * 100 + j) + ". " + b[3][j]);
                }
            }
            System.out.println("Enter index of book to be chosen");
            iss = Integer.parseInt(br.readLine());
        }
        if (ch == 'c') {
            System.out.println("List of all books :");
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 15; j++) {
                    System.out.println("\n" + (i * 100 + j) + ". " + b[i][j]);
                }
            }
            System.out.println("Enter index of book to be chosen");
            iss = Integer.parseInt(br.readLine());

        }
        if (iss != -1) {//finding book physically
            int y1, y2, m = 0;
            String w = " ";
            y1 = iss / 100;
            y2 = iss % 100;
            if (y1 == 0) {
                w = "Physics";
            }
            if (y1 == 1) {
                w = "Chemistry";
            }
            if (y1 == 2) {
                w = "Maths";
            }
            if (y1 == 3) {
                w = "Stories";
            }
            if (y2 % 4 == 0) {
                m = y2 / 4;
            }
            if (y2 % 4 != 0) {
                m = y2 / 4 + 1;
            }
            System.out.println("Find the book at " + w + " Section at shelf number " + m);
        }
    }

    void further() throws IOException//issue ,reborrow,remove reservation, reserve book
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vh = 0;
        if (mbr == r[iss / 100][iss % 100])//book is reserved by member
        {
            System.out.println("you've reserved this book");
            if (vh != 9) {
                if (mb[mbr] == -1)//no book issued
                {
                    System.out.println("1.issue book\n2.remove reservation");
                    f = Integer.parseInt(br.readLine());
                    if (f == 1) {
                        mb[mbr] = iss;
                        vh = 9;
                        System.out.println("You've issued this book");
                    }
                    if (f == 2) {
                        r[iss / 100][iss % 100] = -1;
                        vh = 9;
                        System.out.println("reservation is removed");
                    }
                }
            }
            if (vh != 9) {
                if (mb[mbr] != -1)//another book is issued
                {
                    System.out.println("1.reissue\n2.remove reservation");
                    f = Integer.parseInt(br.readLine());
                    if (f == 1) {
                        mb[mbr] = iss;
                        fincal();
                        vh = 9;
                        System.out.println("book is successfully reissued!!!");
                    }
                    if (f == 2) {
                        r[iss / 100][iss % 100] = -1;
                        vh = 9;
                        System.out.println("reservation is successfully removed");
                    }
                }
            }
        }
        if (mbr != r[iss / 100][iss % 100] && r[iss / 100][iss % 100] == -1)//no book no reserve
        {
            if (vh != 9) {
                if (mb[mbr] == -1)//no book is issued
                {
                    System.out.println("1.issue book\n2.reserve book");
                    f = Integer.parseInt(br.readLine());
                    if (f == 1) {
                        mb[mbr] = iss;
                        vh = 9;
                        System.out.println("You've issued this book");
                    }
                    if (f == 2) {
                        r[iss / 100][iss % 100] = mbr;
                        vh = 9;
                        System.out.println("You've reserved this book");
                    }
                }
            }
            if (vh != 9) {
                if (mb[mbr] != -1)//book is issued
                {
                    System.out.println("1.reissue\n2.reserve book");
                    t = (br.readLine());
                    if (Objects.equals(t, "1")) {
                        mb[mbr] = iss;
                        fincal();
                        vh = 9;
                        System.out.println("book is successfully reissued");
                    }
                    if (Objects.equals(t, "2")) {
                        r[iss / 100][iss % 100] = mbr;
                        vh = 9;
                        System.out.println("book is successfully reserved");
                    }
                }
            }
        }
        if (r[iss / 100][iss % 100] != -1 && vh != 9)//book is not availabe
            System.out.println("book is already reserved");
    }

    void option() throws IOException//to a member
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (per == 1) {
            System.out.println("1.search book\n2.cancel membership\n3.view account\n4.return book");
            f = Integer.parseInt(br.readLine());
            if (f == 1) {
                search_book();
                if (iss != -1)
                    further();
            }
            if (f == 2) {
                for (i = 0; i < 4; i++) {
                    m[mbr][i] = " ";
                }
                if (mb[mbr] != -1)//some book is issued
                {
                    f1 = mb[mbr];
                    r[f1 / 100][f1 % 100] = -1;
                    mb[mbr] = -1;
                    fincal();
                }
                System.out.println("Your membership has been cancelled");
            }
            if (f == 3) {
                System.out.println("Name: " + m[mbr][0]);
                System.out.println("Contact no.: " + m[mbr][1]);
                System.out.println("Email Address: " + m[mbr][2]);
                System.out.println("Address: " + m[mbr][3]);
                if (mb[mbr] > -1)
                    System.out.println("issued: " + b[mb[mbr] / 100][mb[mbr] % 100]);
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 15; j++) {
                        if (r[i][j] == mbr)
                            System.out.println("reserved: " + b[i][j]);
                    }
                }
            }
            if (f == 4) {
                if (mb[mbr] != -1) {
                    mb[mbr] = -1;
                    fincal();
                    System.out.println("Book is returned");
                } else
                    System.out.println("You have not issued any book");
            }
        }
    }

    void fincal() throws IOException//fine calculator
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter number of days you issued book");
        day = Integer.parseInt(br.readLine());
        if (day < 11)
            fine = 0.0;
        if (day > 10) {
            day = day - 10;
            fine = 3.5 * day;
        }
        System.out.println("fine :" + fine);
    }

    void mainmenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You Are:\na. Member\nb. Librarian\nc. Register as Member");
        ch = (char) (br.read());
        if (ch == 'c') {
            ++last_i;
            System.out.println("Welcome to Our Library\nPlease enter following data:\nName :\nContact no. :\nEmail Address:\nAddress:\n");
            est = br.readLine();
            m[last_i][0] = br.readLine();
            m[last_i][1] = br.readLine();
            m[last_i][2] = br.readLine();
            m[last_i][3] = br.readLine();
            System.out.println("Congratulation you are successfully registered as a member of Our Library!!!");
            System.out.println("To continue as a member further, enter \"yes\" otherwise \"no\" :-");
            choice = br.readLine();
            if (choice.equalsIgnoreCase("yes")) {
                identity();
                option();
            }

        }
        if (ch == 'b') {
            System.out.println("Enter your choice\n1.List of members\n2.List of books issued\n3.List of reserved books");
            est = br.readLine();
            t = (br.readLine());
            if (t.equalsIgnoreCase("1")) {
                for (i = 0; i < 50; i++) {
                    if (Objects.equals(m[i][0], " "))
                        break;
                    System.out.println((i + 1) + ". Name: " + m[i][0] + "\nContact: " + m[i][1] + "\nEmail: " + m[i][2] + "\nAddress: " + m[i][3]);
                }
            }
            if (t.equalsIgnoreCase("2")) {
                int bi = 0;
                for (j = 0; j < 50; j++) {
                    if (mb[j] != -1) {
                        ++bi;
                        System.out.println(bi + ". " + b[mb[j] / 100][mb[j] % 100] + " issued by " + m[j][0]);
                    }
                }
            }
            if (t.equalsIgnoreCase("3")) {
                int bi = 0;
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 15; j++) {
                        if (r[i][j] != -1) {
                            ++bi;
                            System.out.println(bi + ". " + b[i][j] + " reserved by " + m[r[i][j]][0]);
                        }
                    }
                }
            }
        }
        if (ch == 'a') {
            identity();
            if (per == 1) {
                option();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String check = " ";
        int yi = 1;
        Library ob = new Library();
        ob.initials();
        do {
            yi++;
            ob.mainmenu();
            System.out.println("to continue further enter \"yes\" otherwise \"no\"");
            check = br.readLine();
            if (!check.equalsIgnoreCase("yes"))
                break;
        } while (yi > 0);

        System.out.println("THANK YOU FOR VISITING US");
    }
}