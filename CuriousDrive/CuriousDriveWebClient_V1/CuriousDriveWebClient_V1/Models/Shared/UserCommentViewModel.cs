using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class UserCommentViewModel
    {
        public int questionId { get; set; }
        public string questionTitle { get; set; }
        public string questionTitleURL { get; set; }
        public string commentHtml { get; set; }
        public string createdDate { get; set; }
    }
}
