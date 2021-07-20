namespace FileStoreApp
{
    public interface IFileWriter
    {
        void WriteText(string message, string filePath);
    }
}