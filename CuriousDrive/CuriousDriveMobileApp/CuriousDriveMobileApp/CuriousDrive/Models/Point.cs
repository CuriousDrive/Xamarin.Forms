using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Point
    {
        public int PointId { get; set; }
        public int QuestionId { get; set; }
        public int? QuestionAnswerId { get; set; }
        public int? UserId { get; set; }
        public int? SubsystemId { get; set; }
        public string SubsystemValue { get; set; }
        public int? SubsystemReferenceId { get; set; }
        public int? PointsTypeId { get; set; }
        public string PointsTypeValue { get; set; }
        public int? Points { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public User User { get; set; }
    }
}
