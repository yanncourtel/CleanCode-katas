namespace FileStoreApp
{
    public interface IWritableFileStore
    {
        void Save(string fileName, string message);
    }
}