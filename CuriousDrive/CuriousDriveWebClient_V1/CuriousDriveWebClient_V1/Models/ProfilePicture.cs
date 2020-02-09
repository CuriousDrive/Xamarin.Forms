namespace CuriousDriveWebClient
{
    public class ProfilePicture
    {
        public ProfilePicture(string astrPictureUrl, string astrNetworkValue, int aintHeight, int aintWidth)
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

