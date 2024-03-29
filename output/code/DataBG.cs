// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DataBG.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace WS.Data {

  /// <summary>Holder for reflection information generated from DataBG.proto</summary>
  public static partial class DataBGReflection {

    #region Descriptor
    /// <summary>File descriptor for DataBG.proto</summary>
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static DataBGReflection() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "CgxEYXRhQkcucHJvdG8SB1dTLkRhdGEiNAoGRGF0YUJHEgoKAmlkGAEgASgF",
            "Eg8KB2JnX25hbWUYAiABKAkSDQoFY29sb3IYAyABKAliBnByb3RvMw=="));
      descriptor = pbr::FileDescriptor.FromGeneratedCode(descriptorData,
          new pbr::FileDescriptor[] { },
          new pbr::GeneratedClrTypeInfo(null, new pbr::GeneratedClrTypeInfo[] {
            new pbr::GeneratedClrTypeInfo(typeof(global::WS.Data.DataBG), global::WS.Data.DataBG.Parser, new[]{ "Id", "BgName", "Color" }, null, null, null)
          }));
    }
    #endregion

  }
  #region Messages
  public sealed partial class DataBG : pb::IMessage<DataBG> {
    private static readonly pb::MessageParser<DataBG> _parser = new pb::MessageParser<DataBG>(() => new DataBG());
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pb::MessageParser<DataBG> Parser { get { return _parser; } }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pbr::MessageDescriptor Descriptor {
      get { return global::WS.Data.DataBGReflection.Descriptor.MessageTypes[0]; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataBG() {
      OnConstruction();
    }

    partial void OnConstruction();

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataBG(DataBG other) : this() {
      id_ = other.id_;
      bgName_ = other.bgName_;
      color_ = other.color_;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public DataBG Clone() {
      return new DataBG(this);
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

    /// <summary>Field number for the "bg_name" field.</summary>
    public const int BgNameFieldNumber = 2;
    private string bgName_ = "";
    /// <summary>
    ///背景图名称
    /// </summary>
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public string BgName {
      get { return bgName_; }
      set {
        bgName_ = pb::ProtoPreconditions.CheckNotNull(value, "value");
      }
    }

    /// <summary>Field number for the "color" field.</summary>
    public const int ColorFieldNumber = 3;
    private string color_ = "";
    /// <summary>
    ///颜色
    /// </summary>
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public string Color {
      get { return color_; }
      set {
        color_ = pb::ProtoPreconditions.CheckNotNull(value, "value");
      }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override bool Equals(object other) {
      return Equals(other as DataBG);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public bool Equals(DataBG other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      if (BgName != other.BgName) return false;
      if (Color != other.Color) return false;
      return true;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0) hash ^= Id.GetHashCode();
      if (BgName.Length != 0) hash ^= BgName.GetHashCode();
      if (Color.Length != 0) hash ^= Color.GetHashCode();
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
      if (BgName.Length != 0) {
        output.WriteRawTag(18);
        output.WriteString(BgName);
      }
      if (Color.Length != 0) {
        output.WriteRawTag(26);
        output.WriteString(Color);
      }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public int CalculateSize() {
      int size = 0;
      if (Id != 0) {
        size += 1 + pb::CodedOutputStream.ComputeInt32Size(Id);
      }
      if (BgName.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(BgName);
      }
      if (Color.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Color);
      }
      return size;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void MergeFrom(DataBG other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0) {
        Id = other.Id;
      }
      if (other.BgName.Length != 0) {
        BgName = other.BgName;
      }
      if (other.Color.Length != 0) {
        Color = other.Color;
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
          case 18: {
            BgName = input.ReadString();
            break;
          }
          case 26: {
            Color = input.ReadString();
            break;
          }
        }
      }
    }

  }

  #endregion

}

#endregion Designer generated code
