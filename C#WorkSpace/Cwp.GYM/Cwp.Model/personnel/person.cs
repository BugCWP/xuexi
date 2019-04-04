using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace Cwp.Model.personnel
{
    public class person
    {
        public Guid id { get; set; }
        public string code { get; set; }
        public string name { get; set; }
        public int age { get; set; }
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
        public string phone { get; set; }
        public string email { get; set; }
        public string sex { get; set; }
        public string accountnumber { get; set; }
        public string password { get; set; }
    }
}