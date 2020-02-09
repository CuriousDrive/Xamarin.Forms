using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class CommentViewModel
    {
        public int commentId { get; set; }
        public string commentHtml { get; set; }
        public string displayName { get; set; }
        public int userId { get; set; }
        public string urlTitle { get; set; }
    }
}
