using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThingToThingCommon
{
   public class RegularExpressions
    {
        public bool IsEmail(string str_Email)
        {
           
           if( System.Text.RegularExpressions.Regex.IsMatch(str_Email, @"^(\w+)(\.\w+)*@(\w+)(\.\w+)*.(\w+)$"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public  bool IsPhone(string str_Phone)
        {
            if(System.Text.RegularExpressions.Regex.IsMatch(str_Phone, @"^1(3|4|5|7|8)\d{9}$"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
