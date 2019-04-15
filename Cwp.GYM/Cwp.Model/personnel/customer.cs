using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.personnel
{
    //客户
    public class customer:person
    {

        public Guid? customerlevelid { get; set; }
        public string customerlevelname { get; set; }
        //注册时间
        public string registeredtime { get; set; }
        public string customerleveltime { get; set; }
    }
}
