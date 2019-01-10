using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 飞行棋
{
    class Program
    {
        public static int[] Maps = new int[100];
        public static int[] Playpos=new int[2];
        public static string[] PlayNames=new string[2];
        
        static void Main(string[] args)
        {
            GameShow();
            Console.WriteLine("请输入玩家A的姓名");
            PlayNames[0] = Console.ReadLine();
            while (PlayNames[0]=="")
            {
                Console.WriteLine("玩家A姓名不能为空,请重新输入");
               
                PlayNames[0] = Console.ReadLine();
            }
            Console.WriteLine("请输入玩家B的姓名");
            PlayNames[1] = Console.ReadLine();
            while (PlayNames[1]=="")
            {
                Console.WriteLine("玩家B姓名不能为空,请重新输入");
          
                PlayNames[1] = Console.ReadLine();
            }
            Console.Clear();
            GameShow();
            Console.WriteLine("{0}用A表示",PlayNames[0]);
            Console.WriteLine("{0}用B表示",PlayNames[1]);
            InitailMap();
            DrawMap();
            Console.ReadKey();
        }

        public static void GameShow()
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("*****************");
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("*****************");
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("***.net.飞行棋***");
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("*****************");
            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("*****************");
        }

        public static void InitailMap()
        {
            int[] luckyturn = {6, 23, 40, 55, 69, 83};
            for (int i = 0; i < luckyturn.Length; i++)
            {
                int index = luckyturn[i];
                Maps[index] = 1;
            }
            int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};
            for (int i = 0; i < landMine.Length; i++)
            {
                int index = landMine[i];
                Maps[index] = 2;
            }
            int[] pause = {9, 27, 60, 93};
            for (int i = 0; i < pause.Length; i++)
            {
                int index = pause[i];
                Maps[index] = 3;
            }
            int[] timeTunnel = {20, 25, 45, 63, 72, 88, 90};
            for (int i = 0; i < timeTunnel.Length; i++)
            {
                int index = timeTunnel[i];
                Maps[index] = 4;
            }
        }

        public static void DrawMap()
        {
         
            for (int i = 0; i < 30; i++)
            {
               Console.Write(DrawStringMap(i));
            }
            Console.WriteLine();
            for (int i = 30; i < 35; i++)
            {
                for (int j = 0; j < 30; j++)
                {
                    Console.Write(" ");
                }
                Console.Write(DrawStringMap(i));
                Console.WriteLine();
            }

            for (int i = 65; i >34; i--)
            {
                Console.Write(DrawStringMap(i));
            }
            Console.WriteLine();
            for (int i = 66; i < 69; i++)
            {
                Console.WriteLine(DrawStringMap(i));
            }
            for (int i = 79; i < 100; i++)
            {
                Console.Write(DrawStringMap(i));
            }
            Console.WriteLine();
        }

        public static string DrawStringMap(int i)
        {
            string str = "";
            if (Playpos[0] == Playpos[1] && Playpos[0] == i)
            {
                str = "<>";
            }
            else if (Playpos[0] == i)
            {
                str="A";
            }
            else if (Playpos[1] == i)
            {
                str="B";
            }
            else
            {
                switch (Maps[i])
                {
                    case 0:
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        str="#";
                        break;
                    case 1:
                        Console.ForegroundColor = ConsoleColor.Green;
                        str="@";
                        break;
                    case 2:
                        Console.ForegroundColor = ConsoleColor.Red;
                        str="$";
                        break;
                    case 3:
                        Console.ForegroundColor = ConsoleColor.Blue;
                        str="&";
                        break;
                    case 4:
                        Console.ForegroundColor = ConsoleColor.DarkCyan;
                        str="*";
                        break;
                }
            }
            return str;
        }
    }
}
