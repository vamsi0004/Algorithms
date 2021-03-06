import java.util.*;
import java.io.*;
class Multi {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
        int x[][] = new int[n][n];
        for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                        x[i][j] = sc.nextInt();
                }

        }
        int i, j, c, a;
        int s[] = new int[20];
        int p[] = new int[20];
        int temp[] = new int[20];
        for (i = 0; i < 10; i++) {
            s[i] = 0;
            temp[i] = 0;
            p[i] = 0;
        }
        System.out.println("Program for MultiStage Graph");
        System.out.println("Select Any one Method\n1. Forward Method\n2. Backward Method");
        a = sc.nextInt();
        switch (a)
        {
            case 1:
                for (i = n-1; i >= 0; i--)
                {
                    c = 0;
                    for (j = 0; j < n; j++)
                    {
                        if (x[i][j] != 0)
                        {
                            if (c == 0)
                            {
                                s[i] = s[j] + x[i][j];
                                p[i] = j;
                                c = 1;
                            }
                            else
                            {
                                temp[i] = s[j] + x[i][j];
                                if (temp[i] < s[i])
                                {
                                    s[i] = s[j] + x[i][j];
                                    p[i] = j;
                                }
                            }
                        }
                    }
                }
                System.out.println("Source  Cost  Parent");
                for (i = n-1; i >= 0; i--)
                    System.out.print("\n  " + i+" \t   " + s[i]+" \t   " + p[i]);
                System.out.println("\nOptimal Path:");
                i = p[0];
                System.out.print("0-->" + i);
                while (i != n-1)
                {
                    i = p[i];
                    System.out.print("-->" + i);
                }
                break;
            case 2:
                for (j = 0; j < n; j++)
                {
                    c = 0;
                    for (i = 0; i < n; i++)
                    {
                        if (x[i][j] != 0)
                        {
                            if (c == 0)
                            {
                                s[j] = s[i] + x[i][j];
                                p[j] = i;
                                c = 1;
                            }
                            else
                            {
                                temp[j] = s[i] + x[i][j];
                                if (temp[j] < s[j])
                                {
                                    s[j] = s[i] + x[i][j];
                                    p[j] = i;
                                }
                            }
                        }
                    }
                }
                System.out.println("Source  Cost   Parent");
                for (i = 0; i < n; i++)
                System.out.print("\n  " + i+" \t   " + s[i]+" \t   " + p[i]);
                System.out.println("\nOptimal Path:");
                i = p[n-1];
                System.out.print((n-1)+"-->" + i);
                while (i != 0)
                {
                    i = p[i];
                    System.out.print("-->" + i);
                }
                break;
        }
    }
}

