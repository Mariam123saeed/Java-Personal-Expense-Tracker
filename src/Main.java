import java.util.Scanner;

// ============================================================================
//  PERSONAL EXPENSE TRACKER  -  STUDENT SKELETON
//  Individual task, Java Fundamentals (first section).
//
//  The menu, the Scanner input and all the printing are ALREADY WRITTEN.
//  Your job is the seven methods marked TODO, and nothing else.
//
//  Scope: variables, operators, if/else, switch, loops, arrays, String
//         methods, Scanner, your own methods.   NO classes, NO ArrayList.
//
//  Everything lives inside main() and is passed to the methods that need it,
//  exactly like findProductIndex(productCodes, code, productCount) in the
//  Store Management lab.  A method can only see its own parameters and its
//  own local variables - nothing leaks between methods.
//
//  Money is int PIASTRES, never double:  4550 piastres = 45.50 EGP
//
//  Run:  java ExpenseTracker.java
// ============================================================================

// ===========================================================================
//  PART A  -  THE SEVEN METHODS YOU MUST WRITE
//  Do them in this order.  Run the program after each one.
// ===========================================================================

// A1. Add up amounts[0] .. amounts[count-1] and return the sum.
//     Careful: loop to count, NOT to amounts.length.
int total(int[] amounts, int count) {
    int total=0;
   // money(count);
    if (count == 0)
    { System.out.println("No expenses yet.");
        return 0;
    }
    for(int i=0;i<count;i++)
    {
        total+=amounts[i];
    }
    return total;A8
}

        // A2. Return the average of the entries, in piastres.
//     If count is 0, return 0 (do not divide by zero).
        int average(int[] amounts, int count) {
            if (count == 0)
            { System.out.println("No expenses yet.");
                return 0;
            }
            int average = (total(amounts,count))/count;
            return average;
        }

        // A3. Return the INDEX of the biggest amount, or -1 if there are none.
//     Return the index, not the amount.
        int highestIndex(int[] amounts, int count) {
            if (count == 0) {
                return -1;
            }
            int highest = 0;
            for (int i = 1; i < count; i++) {
                if (amounts[i] > amounts[highest]) {
                    highest = i;
                }
            }

            return highest;
        }

        // Update1. Return the INDEX of the smallest amount, or -1 if there are none.
        // Return the index, not the amount.
        int lowestIndex(int[] amounts, int count) {
            if (count == 0) {
                return -1;
            }
            int lowest = 0;
            for (int i = 1; i < count; i++) {
                if (amounts[i] < amounts[lowest]) {
                    lowest = i;
                }
            }
A8
            return lowest;
        }

        // A4. Add up only the entries whose category matches.
//     "food" and "Food" must both count -> use .equalsIgnoreCase
        int totalForCategory(String[] categories, int[] amounts, int count, String category) {
            int total = 0;

            for (int i = 0; i < count; i++) {
                if (categories[i].equalsIgnoreCase(category)) {
                    total += amounts[i];
                }
            }
            return total;
        }

        // A5. Return the index of the first description containing text,
//     ignoring case, or -1 if nothing matches.
//     Hint: .toLowerCase() on both sides, then .contains(...)
        int findByDescription(String[] descriptions, int count, String text) {
            for (int i = 0; i < count; i++) {
                if (descriptions[i].toLowerCase().contains(text.toLowerCase())) {
                    return i;
                }
            }
            return -1;
        }

        // A6. Turn piastres into readable money:  4550 -> "45.50 EGP"
//     Pounds are / 100, leftover coins are % 100.
//     A value under 10 must print as 05, not 5.
        String money(int piastres) {
         int Pounds = piastres/100;
         int Coins = piastres%100;A8
          if (Coins<10)
          {
              return Pounds+"."+"0"+Coins;
          }

            return Pounds+"."+Coins;
        }

        // A7. Return a bar of '#' whose length is amount out of 20,
//     scaled against biggest.  Never return an empty bar for a
//     non-zero amount - show at least one '#'.
        String bar(int amount, int biggest) {
            if (amount == 0  ) {
                return "";
            }

            int blocks = amount * 20 / biggest;
            if(blocks<1)
            {
                blocks=1;
            }
            String result = "";
            for (int i = 0; i < blocks; i++) {
                result += "#";
            }
            return result;

        }

// ===========================================================================
//  PART B  -  ALREADY WRITTEN FOR YOU.  Read it, do not change it.
// ===========================================================================

        // Returns the new count (one bigger on success, unchanged if full).
        int addExpense(Scanner in, String[] descriptions, String[] categories,
                       int[] amounts, int count) {
            if (count == amounts.length) {
                System.out.println("The tracker is full.");
                return count;
            }
            System.out.print("Description: ");
            String d = in.nextLine();
            System.out.print("Category (Food/Transport/Bills/Fun): ");
            String c = in.nextLine();
            // System.out.print("Amount in piastres (e.g. 4550 = 45.50): ");
            //int a = Integer.parseInt(in.nextLine());
            //Update3
            int a;
            while(true)
            {
                System.out.print("Amount in piastres (e.g. 4550 = 45.50): ");
                a = Integer.parseInt(in.nextLine());
                if (a<0)
                {
                   break;
                }
                System.out.print("Amount can't be negative,Please enter it again!");

            }
            descriptions[count] = d;
            categories[count] = c;
            amounts[count] = a;

            return count + 1;
        }

        void listExpenses(String[] descriptions, String[] categories, int[] amounts, int count) {
            if (count == 0) { System.out.println("No expenses yet."); return; }
            System.out.println("--------------------------------------------");
            for (int i = 0; i < count; i++) {
                System.out.println("[" + i + "] " + descriptions[i]
                        + " (" + categories[i] + ") " + money(amounts[i]));
            }
            System.out.println("--------------------------------------------");
            System.out.println("Total: " + money(total(amounts, count)));
        }

        void showSummary(String[] descriptions, int[] amounts, int count) {
            if (count == 0) { System.out.println("No expenses yet."); return; }
            System.out.println("Entries : " + count);
            System.out.println("Total   : " + money(total(amounts, count)));
            System.out.println("Average : " + money(average(amounts, count)));
            int h = highestIndex(amounts, count);
            if (h < 0 || h >= count) System.out.println("Biggest : (highestIndex() not written yet)");
            else System.out.println("Biggest : " + descriptions[h] + " " + money(amounts[h]));
            //Update2
            int totalAmount=total(amounts,count);
            int percentage = amounts[h] *100/totalAmount;
            System.out.println("Biggest : " + percentage + "%");

        }

        void showChart(String[] categories, int[] amounts, int count) {
            if (count == 0) { System.out.println("No expenses yet."); return; }
            String[] names = {"Food", "Transport", "Bills", "Fun"};
            int biggest = 0;
            for (String n : names) {
                int t = totalForCategory(categories, amounts, count, n);
                if (t > biggest) biggest = t;
            }
            for (String n : names) {
                int t = totalForCategory(categories, amounts, count, n);
                //Update 4
                int entires=0;
                for(int i=0;i<count;i++)
                {
                    if(categories[i].equalsIgnoreCase(n))
                    {
                        entires++;
                    }
                }
                System.out.println(pad(n) + " | " + bar(t, biggest) + " " + money(t) + "(" +entires + "entires)");

            }

        }

        String pad(String s) {
            String r = s;
            while (r.length() < 9) r += " ";
            return r;
        }

        void search(Scanner in, String[] descriptions, int[] amounts, int count) {
            System.out.print("Search text: ");
            String t = in.nextLine();
            int i = findByDescription(descriptions, count, t);
            if (i == -1) System.out.println("No expense matches \"" + t + "\".");
            else System.out.println("Found [" + i + "] " + descriptions[i] + " " + money(amounts[i]));
        }

        void main() {
            final int MAX = 50;
            // The data lives here, in main. Every method that needs it gets it
            // passed in as a parameter.
            String[] descriptions = new String[MAX];
            String[] categories   = new String[MAX];
            int[]    amounts      = new int[MAX];
            int      count        = 0;

            Scanner in = new Scanner(System.in);
            boolean running = true;

            System.out.println("============================");
            System.out.println("  PERSONAL EXPENSE TRACKER");
            System.out.println("============================");

            while (running) {
                System.out.println();
                System.out.println("1) Add expense");
                System.out.println("2) List all expenses");
                System.out.println("3) Summary");
                System.out.println("4) Spending by category");
                System.out.println("5) Search");
                System.out.println("6) Quit");
                System.out.println("7) Lowest expense");
                System.out.print("Choose: ");
                String choice = in.nextLine();
                System.out.println();
                switch (choice) {
                    case "1":
                        count = addExpense(in, descriptions, categories, amounts, count);
                        break;
                    case "2": listExpenses(descriptions, categories, amounts, count); break;
                    case "3": showSummary(descriptions, amounts, count); break;
                    case "4": showChart(categories, amounts, count); break;
                    case "5": search(in, descriptions, amounts, count); break;
                    case "6": running = false; System.out.println("Goodbye."); break;
                    case "7":
                        int l= lowestIndex(amounts,count);
                        if (l ==-1)
                        {System.out.println("Lowest : " + descriptions[l] + " " + money(amounts[l]));}
                        break;
                    default: System.out.println("Unknown choice: " + choice);
                }
            }
        }