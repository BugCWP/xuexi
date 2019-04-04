using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;
namespace  ThingToThingDAL
{
    public class sqlHelp
    {
        public static string connstring = "Data Source=DESKTOP-PI37QUM;Initial Catalog=ThingToThing;Persist Security Info=True;User ID=sa;Password=123";
        public static SqlConnection con = new SqlConnection(connstring);
         
        public static int ExecuteNonQuery(string sql, SqlParameter[] ps)
        {
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Parameters.AddRange(ps);
            int res = cmd.ExecuteNonQuery();
            con.Close();
            return res;
        }

        public static SqlDataReader ExecuteReader(string sql,SqlParameter[] ps)
        {
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Parameters.AddRange(ps);
            SqlDataReader sdr= cmd.ExecuteReader();
            con.Close();
            return sdr;
        }

        public static object ExecuteScalar(string sql,SqlParameter[] ps)
        {
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Parameters.AddRange(ps);
            object res= cmd.ExecuteScalar();
            con.Close();
            return res;
        }
        public static DataTable getDatable(string sql,SqlParameter[] ps)
        {
            
           
            SqlDataAdapter sda = new SqlDataAdapter(sql,con);
            sda.SelectCommand.Parameters.AddRange(ps);
            DataTable dt = new DataTable();
            sda.Fill(dt);
           
            return dt;
        }
        public static DataTable getDatable(string sql)
        {
           
            SqlDataAdapter sda = new SqlDataAdapter(sql, con);
            DataTable dt = new DataTable();
            sda.Fill(dt);
           
            return dt;
        }

    }
}
