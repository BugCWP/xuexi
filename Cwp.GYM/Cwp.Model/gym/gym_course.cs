using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    public class gym_course
    {
        public Guid? id { get; set; }
        public Guid? courseid { get; set; }
        public string coursename { get; set; }
        public Guid? coachid { get; set; }
        public string coachname { get; set; }
        public Guid? gymid { get; set; }
        public string gymname { get; set; }
        public string amount { get; set; }
        //课程状态（等待，进行，结束）
        public string startstatus { get; set; }
        public Guid? code { get; set; }
        public string starttime { get; set; }
        public string duration { get; set; }
    }
}
