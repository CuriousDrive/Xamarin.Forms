using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Global
{
    public class busProfilePicture
    {
        public busProfilePicture(string astrPictureUrl, string astrNetworkValue, int aintHeight, int aintWidth)
        {
            istrPictureUrl = astrPictureUrl;
            istrNetworkValue = astrNetworkValue;
            iintHeight = aintHeight;
            iintWidth = aintWidth;
        }

        public string istrPictureUrl;
        public string istrNetworkValue;
        public int iintHeight;
        public int iintWidth;
        
    }
}