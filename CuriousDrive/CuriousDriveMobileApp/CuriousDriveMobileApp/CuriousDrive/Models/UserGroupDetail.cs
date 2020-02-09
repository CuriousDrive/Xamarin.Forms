using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class UserGroupDetail
    {
        public int UserGroupDetailId { get; set; }
        public int UserGroupId { get; set; }
        public int UserId { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public User User { get; set; }
        public UserGroup UserGroup { get; set; }
    }
}
