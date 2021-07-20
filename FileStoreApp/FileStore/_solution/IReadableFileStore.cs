namespace FileStoreApp
{
    public interface IReadableFileStore
    {
        string Read(string fileName);
    }
}