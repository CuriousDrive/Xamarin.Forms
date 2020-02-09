using CuriousDriveWebAPI.CuriousDrive.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class AskQuestionViewModel
    {
        public int questionId { get; set; }
        public string questionTitleURL { get; set; }
        public string questionTitle { get; set; }
        public string questionHtml { get; set; }
        public List<ClassViewModel> classesViewModel { get; set; }
        public string selectedClass { get; set; }
    }
}
