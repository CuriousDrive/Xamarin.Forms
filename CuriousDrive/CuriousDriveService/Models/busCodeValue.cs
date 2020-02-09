using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class doCodeValue
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int codeValueId { get; set; }
        public int codeId { get; set; }
        public string codeValue { get; set; }
        public string comments { get; set; }
        public string data1 { get; set; }
        public string data2 { get; set; }
        public string data3 { get; set; }
        public string description { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busCodeValue : busBase
    {
        public doCodeValue idoCodeValue { get; set; }
    }
}
