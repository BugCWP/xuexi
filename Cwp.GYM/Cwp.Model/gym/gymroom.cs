using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    //健身房表
    public class gymroom
    {
        public Guid id { get; set; }
        public string name { get; set; }
        //省地址
        public Guid provinceaddressid { get; set; }
        //市地址
        public Guid cityadressid { get; set; }
        //区地址
        public Guid areaadressid { get; set; }
        //街道地址
        public Guid streetadressid { get; set; }
        //详细地址
        public string specificaddress { get; set; }
        public string remark;
        public bool status;
        //开始营业时间
        public string start_time { get; set; }
        //结束营业时间
        public string end_time { get; set; }

    }
}
