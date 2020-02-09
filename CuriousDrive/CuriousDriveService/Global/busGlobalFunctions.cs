using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

namespace CuriousDriveService.Global
{
	public class busGlobalFunctions
	{
        public void GetBaseUrl(ref string astrBaseUrl, ref string astrRequestUrl, string astrModule){

			switch(busConstant.Region) {

			case "UAT":
				astrBaseUrl = "http://localhost:8080/";
				astrRequestUrl = "CuriousDriveWebService" + astrModule;	
				break;
	
			case "SYS":
				astrBaseUrl = "http://localhost:8080/";
				astrRequestUrl = "CuriousDriveWebService" + astrModule;	
				break;

			case "DEV":
				astrBaseUrl = "http://localhost:8080/";
				astrRequestUrl = "api" + astrModule;	
				break;
			}
		}

		public static string GetMd5Hash(MD5 md5Hash,string input)
		{
            if (input == null)
                input = "";
			// Convert the input string to a byte array and compute the hash.
			byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(input));

			// Create a new Stringbuilder to collect the bytes
			// and create a string.
			StringBuilder sBuilder = new StringBuilder();

			// Loop through each byte of the hashed data 
			// and format each one as a hexadecimal string.
			for (int i = 0; i < data.Length; i++)
			{
				sBuilder.Append(data[i].ToString("x2"));
			}

			// Return the hexadecimal string.
			return sBuilder.ToString();
		}

		// Verify a hash against a string.
		public static bool VerifyMd5Hash(MD5 md5Hash, string input, string hash)
		{
			// Hash the input.
			string hashOfInput = GetMd5Hash(md5Hash, input);

			// Create a StringComparer an compare the hashes.
			StringComparer comparer = StringComparer.OrdinalIgnoreCase;

			if (0 == comparer.Compare(hashOfInput, hash))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

        public string GetIPAddress()
        {
            System.Web.HttpContext context = System.Web.HttpContext.Current;

            string ipAddress = context.Request.UserHostAddress;

            if (!string.IsNullOrEmpty(ipAddress))
            {
                string[] addresses = ipAddress.Split(',');
                if (addresses.Length != 0)
                {
                    return addresses[0];
                }
            }

            return context.Request.ServerVariables["REMOTE_ADDR"];
        }

        public static string GenerateRandomOTP(int aintOTPLength)
        {
            string[] lstrarrAllowedCharacters = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0" };
            string lstrOTP = String.Empty;
            string lstrTempChars = String.Empty;
            Random rand = new Random();

            for (int i = 0; i < aintOTPLength; i++)
            {
                int p = rand.Next(0, lstrarrAllowedCharacters.Length);
                lstrTempChars = lstrarrAllowedCharacters[rand.Next(0, lstrarrAllowedCharacters.Length)];
                lstrOTP += lstrTempChars;
            }

            return lstrOTP;

        }

        public static string Encrypt(string text)
        {
            byte[] key = new byte[8] { 1, 2, 3, 4, 5, 6, 7, 8 };
            byte[] iv = new byte[8] { 1, 2, 3, 4, 5, 6, 7, 8 };

            SymmetricAlgorithm algorithm = DES.Create();
            ICryptoTransform transform = algorithm.CreateEncryptor(key, iv);
            byte[] inputbuffer = Encoding.Unicode.GetBytes(text);
            byte[] outputBuffer = transform.TransformFinalBlock(inputbuffer, 0, inputbuffer.Length);
            return Convert.ToBase64String(outputBuffer);
        }

        public static string Decrypt( string text)
        {
            byte[] key = new byte[8] { 1, 2, 3, 4, 5, 6, 7, 8 };
            byte[] iv = new byte[8] { 1, 2, 3, 4, 5, 6, 7, 8 };

            SymmetricAlgorithm algorithm = DES.Create();
            ICryptoTransform transform = algorithm.CreateDecryptor(key, iv);
            byte[] inputbuffer = Convert.FromBase64String(text);
            byte[] outputBuffer = transform.TransformFinalBlock(inputbuffer, 0, inputbuffer.Length);
            return Encoding.Unicode.GetString(outputBuffer);
        }

        public static string GetSaltValue()
        {
            string[] lstrarrRandomWords = { "something", "Password", "top", "baby", "Disney", "perfect", "Kiss", "world",
                                            "Nanny", "mom", "Dog", "pig", "Dad", "123456", "qwerty", "Letmein", "Football",
                                            "iloveyou", "Admin", "welcome", "Monkey", "login", "abc123", "starwars", "Dragon",
                                            "passw0rd", "master", "hello", "Freedom", "Whatever", "qazwsx", "trustno1"};

            Random random = new Random();
            int lintRandom = random.Next(0, lstrarrRandomWords.Length);

            return lstrarrRandomWords[lintRandom];
        }
    }
}

