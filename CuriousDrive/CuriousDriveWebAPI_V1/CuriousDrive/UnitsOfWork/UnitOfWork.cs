using CuriousDriveWebAPI.CuriousDrive.Models;
using CuriousDriveWebAPI.CuriousDrive.Repositories;

namespace CuriousDriveWebAPI.CuriousDrive.UnitsOfWork
{
    public class UnitOfWork : IUnitOfWork
    {
        private readonly CuriousDriveContext _context;

        public UnitOfWork(CuriousDriveContext context)
        {
            _context = context;
            Roles = new RoleRepository(_context);
            Messages = new MessageRepository(_context);
            Users = new UserRepository(_context);
            Questions = new QuestionRepository(_context);
            Classes = new ClassRepository(_context);
            QuestionAnswers = new QuestionAnswerRepository(_context);
            QuestionClasses = new QuestionClassRepository(_context);
            Comments = new CommentRepository(_context);
            Tags = new TagRepository(_context);
            TagDetails = new TagDetailRepository(_context);
            Feedback = new FeedbackRepository(_context);
        }

        public IRoleRepository Roles { get; private set; }
        public IMessageRepository Messages { get; private set; }
        public IUserRepository Users { get; private set; }
        public IQuestionRepository Questions { get; private set; }
        public IQuestionAnswerRepository QuestionAnswers { get; private set; }
        public IQuestionClassRepository QuestionClasses { get; private set; }
        public IClassRepository Classes { get; private set; }
        public ICommentRepository Comments { get; private set; }
        public ITagRepository Tags { get; private set; }
        public ITagDetailRepository TagDetails { get; private set; }
        public IFeedbackRepository Feedback { get; private set; }

        public int Complete()
        {
            return _context.SaveChanges();
        }

        public void Dispose()
        {
            _context.Dispose();
        }
    }
}