using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlazorApp.Data
{
    interface IAuthorService
    {
        List<Author> GetAuthors();
        Author GetAuthorById(string authorId);

        DateTime GetCreatedDate();
        string GetVersion();
    }
}
