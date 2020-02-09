using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class UserQuestionViewModel
    {
        public int questionId { get; set; }
        public string questionTitle { get; set; }        
        public string questionTitleURL { get; set; }
        public string createdDate { get; set; }
    }
}
