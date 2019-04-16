using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    //开设的课程
    public class course
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public string remark { get; set; }
        //课程种类(大课，私教)
        public string coursetype { get; set; }
        //课程费
        public string price { get; set; }
        //报酬
        public string remuneration { get; set; }
        //课程会员等级(普通会员，高级会员)
        public string customerlevel { get; set; }
        //课程教练等级（高级，中级，初级）
        public string  coachlevel { get; set; }
    }
}
