using CuriousDriveWebAPI.CuriousDrive.Models;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public interface IQuestionClassRepository : IRepository<QuestionClass>
    {
        List<QuestionClass> GetQuestionClassesByQuestionId(int questionId);
    }
}