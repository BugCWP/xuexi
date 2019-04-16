using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    //设备表
    public class equipment
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public Guid? code { get; set; }
        public string price { get; set; }
        public string remark { get; set; }
    }
}
