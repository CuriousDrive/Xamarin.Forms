namespace CuriousDriveWebAPI.CuriousDrive
{
    public class Utility
    {
        public static string GetURLTitle(string str)
        {
            if (str != null && str != string.Empty)
            {
                str = str.ToLower();
                str = str.Replace(" ", "_");
                return str;
            }

            return string.Empty;
        }

    }
}
