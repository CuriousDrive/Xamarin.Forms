using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class doRole
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int roleId { get; set; }
        public string roleDescription { get; set; }
        public string roleName { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busRole
    {
        public doRole idoRole { get; set; }
    }
}