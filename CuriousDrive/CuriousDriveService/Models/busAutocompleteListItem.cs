using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class busAutocompleteListItem
    {
        public string istrLabel { get; set; }
        public string istrUserGroupType { get; set; }
        public string istrValue { get; set; }

        public busAutocompleteListItem(string astrLabel,string astrUserGroupType, string astrValue)
        {
            istrLabel = astrLabel;
            istrUserGroupType = astrUserGroupType;
            istrValue = astrValue;
        }
    }
}
