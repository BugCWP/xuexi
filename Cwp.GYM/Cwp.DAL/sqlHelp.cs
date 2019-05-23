using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.DAL
{
    public class sqlHelp
    {
        //public static string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
        //public static SqlConnection con = new SqlConnection(connstring);

        public static int ExecuteNonQuery(string sql, SqlParameter[] ps)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
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

        public static SqlDataReader ExecuteReader(string sql, SqlParameter[] ps)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Parameters.AddRange(ps);
            SqlDataReader sdr = cmd.ExecuteReader();
            con.Close();
            return sdr;
        }

        public static object ExecuteScalar(string sql, SqlParameter[] ps)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Parameters.AddRange(ps);
            object res = cmd.ExecuteScalar();
            con.Close();
            return res;
        }

        public static object ExecuteScalar(string sql)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            cmd.CommandType = System.Data.CommandType.Text;
            object res = cmd.ExecuteScalar();
            con.Close();
            return res;
        }

        public static DataTable getDatable(string sql, SqlParameter[] ps)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
            try
            {
                SqlDataAdapter sda = new SqlDataAdapter(sql, con);
                sda.SelectCommand.Parameters.AddRange(ps);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                return dt;
            }
            catch (Exception e)
            {
                throw (e);
            }
        }
        public static DataTable getDatable(string sql)
        {
            string connstring = "Data Source=DESKTOP-U3PTEKD\\SQLEXPRESS;Initial Catalog=GYM;Persist Security Info=True;User ID=sa;Password=p@ssw0rd";
            SqlConnection con = new SqlConnection(connstring);
            try
            {
                SqlDataAdapter sda = new SqlDataAdapter(sql, con);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                return dt;
            }
            catch (Exception e)
            {
                throw (e);
            }
        }
    }
}
