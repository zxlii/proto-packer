// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DataEffect.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace WS.Data {

  /// <summary>Holder for reflection information generated from DataEffect.proto</summary>
  public static partial class DataEffectReflection {

    #region Descriptor
    /// <summary>File descriptor for DataEffect.proto</summary>
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static DataEffectReflection() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "ChBEYXRhRWZmZWN0LnByb3RvEgdXUy5EYXRhIjwKCkRhdGFFZmZlY3QSCgoC",
            "aWQYASABKAUSEAoIZmlsZU5hbWUYAyABKAkSEAoIZHVyYXRpb24YBCABKAJi",
            "BnByb3RvMw=="));
      descriptor = pbr::FileDescriptor.FromGeneratedCode(descriptorData,
          new pbr::FileDescriptor[] { },
          new pbr::GeneratedClrTypeInfo(null, new pbr::GeneratedClrTypeInfo[] {
            new pbr::GeneratedClrTypeInfo(typeof(global::WS.Data.DataEffect), global::WS.Data.DataEffect.Parser, new[]{ "Id", "FileName", "Duration" }, null, null, null)
          }));
    }
    #endregion

  }
  #region Messages
  public sealed partial class DataEffect : pb::IMessage<DataEffect> {
    private static readonly pb::MessageParser<DataEffect> _parser = new pb::MessageParser<DataEffect>(() => new DataEffect());
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pb::MessageParser<DataEffect> Parser { get { return _parser; } }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pbr::MessageDescriptor Descriptor {
      get { return global::WS.Data.DataEffectReflection.Descriptor.MessageTypes[0]; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataEffect() {
      OnConstruction();
    }

    partial void OnConstruction();

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataEffect(DataEffect other) : this() {
      id_ = other.id_;
      fileName_ = other.fileName_;
      duration_ = other.duration_;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataEffect Clone() {
      return new DataEffect(this);
    }

    /// <summary>Field number for the "id" field.</summary>
    public const int IdFieldNumber = 1;
    private int id_;
    /// <summary>
    ///唯一标识
    /// </summary>
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public int Id {
      get { return id_; }
      set {
        id_ = value;
      }
    }

    /// <summary>Field number for the "fileName" field.</summary>
    public const int FileNameFieldNumber = 3;
    private string fileName_ = "";
    /// <summary>
    ///文件名
    /// </summary>
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public string FileName {
      get { return fileName_; }
      set {
        fileName_ = pb::ProtoPreconditions.CheckNotNull(value, "value");
      }
    }

    /// <summary>Field number for the "duration" field.</summary>
    public const int DurationFieldNumber = 4;
    private float duration_;
    /// <summary>
    ///时长（秒）
    /// </summary>
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public float Duration {
      get { return duration_; }
      set {
        duration_ = value;
      }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override bool Equals(object other) {
      return Equals(other as DataEffect);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public bool Equals(DataEffect other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      if (FileName != other.FileName) return false;
      if (Duration != other.Duration) return false;
      return true;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0) hash ^= Id.GetHashCode();
      if (FileName.Length != 0) hash ^= FileName.GetHashCode();
      if (Duration != 0F) hash ^= Duration.GetHashCode();
      return hash;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override string ToString() {
      return pb::JsonFormatter.ToDiagnosticString(this);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void WriteTo(pb::CodedOutputStream output) {
      if (Id != 0) {
        output.WriteRawTag(8);
        output.WriteInt32(Id);
      }
      if (FileName.Length != 0) {
        output.WriteRawTag(26);
        output.WriteString(FileName);
      }
      if (Duration != 0F) {
        output.WriteRawTag(37);
        output.WriteFloat(Duration);
      }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public int CalculateSize() {
      int size = 0;
      if (Id != 0) {
        size += 1 + pb::CodedOutputStream.ComputeInt32Size(Id);
      }
      if (FileName.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(FileName);
      }
      if (Duration != 0F) {
        size += 1 + 4;
      }
      return size;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void MergeFrom(DataEffect other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0) {
        Id = other.Id;
      }
      if (other.FileName.Length != 0) {
        FileName = other.FileName;
      }
      if (other.Duration != 0F) {
        Duration = other.Duration;
      }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 8: {
            Id = input.ReadInt32();
            break;
          }
          case 26: {
            FileName = input.ReadString();
            break;
          }
          case 37: {
            Duration = input.ReadFloat();
            break;
          }
        }
      }
    }

  }

  #endregion

}

#endregion Designer generated code
