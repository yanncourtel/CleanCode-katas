using System;

namespace FileStoreApp
{
    public interface IFileStore : IWritableFileStore, IReadableFileStore
    {
    }
}