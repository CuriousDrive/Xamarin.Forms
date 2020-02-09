using System;
using RestSharp;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace CuriousDriveService.Global
{
    public class busRestService
    {
        busGlobalFunctions ibusGlobalFunctions = null;
        string istrBaseUrl = string.Empty;
        string istrRequestUrl = string.Empty;

        public List<T> GetList<T>(string astrModueUrl)
        {
            try
            {
                ibusGlobalFunctions = new busGlobalFunctions();
                ibusGlobalFunctions.GetBaseUrl(ref istrBaseUrl, ref istrRequestUrl, astrModueUrl);

                var client = new RestClient(istrBaseUrl);
                var request = new RestRequest(istrRequestUrl, Method.GET);

                string lstrContent = client.Execute(request).Content;
                List<T> list = JsonConvert.DeserializeObject<List<T>>(lstrContent);
                return list;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return null;
            }
        }

        public T Get<T>(string astrModueUrl)
        {
            try
            {
                ibusGlobalFunctions = new busGlobalFunctions();
                ibusGlobalFunctions.GetBaseUrl(ref istrBaseUrl, ref istrRequestUrl, astrModueUrl);

                var client = new RestClient(istrBaseUrl);
                var request = new RestRequest(istrRequestUrl, Method.GET);

                string lstrContent = client.Execute(request).Content;

                if (typeof(T) == typeof(string) || typeof(T) == typeof(int) || typeof(T) == typeof(decimal))
                {
                    return (T)Convert.ChangeType(lstrContent, typeof(T));
                }

                T obj = JsonConvert.DeserializeObject<T>(lstrContent);
                return obj;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return default(T);
            }
            
        }
        
        public T Post<T>(string astrModueUrl, object aObject)
        {
            try
            {
                ibusGlobalFunctions = new busGlobalFunctions();
                ibusGlobalFunctions.GetBaseUrl(ref istrBaseUrl, ref istrRequestUrl, astrModueUrl);

                var client = new RestClient(istrBaseUrl);
                var request = new RestRequest(istrRequestUrl, Method.POST);

                var json = JsonConvert.SerializeObject(aObject, Newtonsoft.Json.Formatting.None,
                            new JsonSerializerSettings { NullValueHandling = NullValueHandling.Ignore });
                request.AddParameter("application/json; charset=utf-8", json, ParameterType.RequestBody);

                string lstrContent = client.Execute(request).Content;
                T obj = JsonConvert.DeserializeObject<T>(lstrContent);
                return obj;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return default(T);
            }
        }

        public T Delete<T>(string astrModueUrl)
        {
            try
            {
                ibusGlobalFunctions = new busGlobalFunctions();
                ibusGlobalFunctions.GetBaseUrl(ref istrBaseUrl, ref istrRequestUrl, astrModueUrl);

                var client = new RestClient(istrBaseUrl);
                var request = new RestRequest(istrRequestUrl, Method.DELETE);

                string lstrContent = client.Execute(request).Content;
                T obj = JsonConvert.DeserializeObject<T>(lstrContent);
                return obj;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return default(T);
            }
        }
    }
}

