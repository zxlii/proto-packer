// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Constance.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace WS.Data {

  /// <summary>Holder for reflection information generated from Constance.proto</summary>
  public static partial class ConstanceReflection {

    #region Descriptor
    /// <summary>File descriptor for Constance.proto</summary>
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static ConstanceReflection() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "Cg9Db25zdGFuY2UucHJvdG8SB1dTLkRhdGEaGkRhdGFMdWNreUJhZ1VzZXJU",
            "eXBlLnByb3RvGhBEYXRhR2xvYmFsLnByb3RvGhBEYXRhTGV0dGVyLnByb3Rv",
            "GhFEYXRhUGF5bWVudC5wcm90bxoURGF0YUxldmVsV29yZHMucHJvdG8aD0Rh",
            "dGFQaWVjZS5wcm90bxoQRGF0YVNpZ25Jbi5wcm90bxobRGF0YUx1Y2t5QmFn",
            "UmFuZG9tUHJvLnByb3RvGg9EYXRhU3R5bGUucHJvdG8aEERhdGFFZmZlY3Qu",
            "cHJvdG8aD0RhdGFMZXZlbC5wcm90bxocRGF0YUx1Y2t5QmFnUmFuZG9tQ29p",
            "bi5wcm90bxoWRGF0YUx1Y2t5QmFnU2hvdy5wcm90bxoORGF0YVRvb2wucHJv",
            "dG8ilwUKCUNvbnN0YW5jZRI7ChRsdWNreUJhZ1VzZXJUeXBlTGlzdBgBIAMo",
            "CzIdLldTLkRhdGEuRGF0YUx1Y2t5QmFnVXNlclR5cGUSJwoKZ2xvYmFsTGlz",
            "dBgCIAMoCzITLldTLkRhdGEuRGF0YUdsb2JhbBInCgpsZXR0ZXJMaXN0GAMg",
            "AygLMhMuV1MuRGF0YS5EYXRhTGV0dGVyEikKC3BheW1lbnRMaXN0GAQgAygL",
            "MhQuV1MuRGF0YS5EYXRhUGF5bWVudBIvCg5sZXZlbFdvcmRzTGlzdBgFIAMo",
            "CzIXLldTLkRhdGEuRGF0YUxldmVsV29yZHMSJQoJcGllY2VMaXN0GAYgAygL",
            "MhIuV1MuRGF0YS5EYXRhUGllY2USJwoKc2lnbkluTGlzdBgHIAMoCzITLldT",
            "LkRhdGEuRGF0YVNpZ25JbhI9ChVsdWNreUJhZ1JhbmRvbVByb0xpc3QYCCAD",
            "KAsyHi5XUy5EYXRhLkRhdGFMdWNreUJhZ1JhbmRvbVBybxIlCglzdHlsZUxp",
            "c3QYCSADKAsyEi5XUy5EYXRhLkRhdGFTdHlsZRInCgplZmZlY3RMaXN0GAog",
            "AygLMhMuV1MuRGF0YS5EYXRhRWZmZWN0EiUKCWxldmVsTGlzdBgLIAMoCzIS",
            "LldTLkRhdGEuRGF0YUxldmVsEj8KFmx1Y2t5QmFnUmFuZG9tQ29pbkxpc3QY",
            "DCADKAsyHy5XUy5EYXRhLkRhdGFMdWNreUJhZ1JhbmRvbUNvaW4SMwoQbHVj",
            "a3lCYWdTaG93TGlzdBgNIAMoCzIZLldTLkRhdGEuRGF0YUx1Y2t5QmFnU2hv",
            "dxIjCgh0b29sTGlzdBgOIAMoCzIRLldTLkRhdGEuRGF0YVRvb2xiBnByb3Rv",
            "Mw=="));
      descriptor = pbr::FileDescriptor.FromGeneratedCode(descriptorData,
          new pbr::FileDescriptor[] { global::WS.Data.DataLuckyBagUserTypeReflection.Descriptor, global::WS.Data.DataGlobalReflection.Descriptor, global::WS.Data.DataLetterReflection.Descriptor, global::WS.Data.DataPaymentReflection.Descriptor, global::WS.Data.DataLevelWordsReflection.Descriptor, global::WS.Data.DataPieceReflection.Descriptor, global::WS.Data.DataSignInReflection.Descriptor, global::WS.Data.DataLuckyBagRandomProReflection.Descriptor, global::WS.Data.DataStyleReflection.Descriptor, global::WS.Data.DataEffectReflection.Descriptor, global::WS.Data.DataLevelReflection.Descriptor, global::WS.Data.DataLuckyBagRandomCoinReflection.Descriptor, global::WS.Data.DataLuckyBagShowReflection.Descriptor, global::WS.Data.DataToolReflection.Descriptor, },
          new pbr::GeneratedClrTypeInfo(null, new pbr::GeneratedClrTypeInfo[] {
            new pbr::GeneratedClrTypeInfo(typeof(global::WS.Data.Constance), global::WS.Data.Constance.Parser, new[]{ "LuckyBagUserTypeList", "GlobalList", "LetterList", "PaymentList", "LevelWordsList", "PieceList", "SignInList", "LuckyBagRandomProList", "StyleList", "EffectList", "LevelList", "LuckyBagRandomCoinList", "LuckyBagShowList", "ToolList" }, null, null, null)
          }));
    }
    #endregion

  }
  #region Messages
  public sealed partial class Constance : pb::IMessage<Constance> {
    private static readonly pb::MessageParser<Constance> _parser = new pb::MessageParser<Constance>(() => new Constance());
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pb::MessageParser<Constance> Parser { get { return _parser; } }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public static pbr::MessageDescriptor Descriptor {
      get { return global::WS.Data.ConstanceReflection.Descriptor.MessageTypes[0]; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public Constance() {
      OnConstruction();
    }

    partial void OnConstruction();

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public Constance(Constance other) : this() {
      luckyBagUserTypeList_ = other.luckyBagUserTypeList_.Clone();
      globalList_ = other.globalList_.Clone();
      letterList_ = other.letterList_.Clone();
      paymentList_ = other.paymentList_.Clone();
      levelWordsList_ = other.levelWordsList_.Clone();
      pieceList_ = other.pieceList_.Clone();
      signInList_ = other.signInList_.Clone();
      luckyBagRandomProList_ = other.luckyBagRandomProList_.Clone();
      styleList_ = other.styleList_.Clone();
      effectList_ = other.effectList_.Clone();
      levelList_ = other.levelList_.Clone();
      luckyBagRandomCoinList_ = other.luckyBagRandomCoinList_.Clone();
      luckyBagShowList_ = other.luckyBagShowList_.Clone();
      toolList_ = other.toolList_.Clone();
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public Constance Clone() {
      return new Constance(this);
    }

    /// <summary>Field number for the "luckyBagUserTypeList" field.</summary>
    public const int LuckyBagUserTypeListFieldNumber = 1;
    private static readonly pb::FieldCodec<global::WS.Data.DataLuckyBagUserType> _repeated_luckyBagUserTypeList_codec
        = pb::FieldCodec.ForMessage(10, global::WS.Data.DataLuckyBagUserType.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLuckyBagUserType> luckyBagUserTypeList_ = new pbc::RepeatedField<global::WS.Data.DataLuckyBagUserType>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLuckyBagUserType> LuckyBagUserTypeList {
      get { return luckyBagUserTypeList_; }
    }

    /// <summary>Field number for the "globalList" field.</summary>
    public const int GlobalListFieldNumber = 2;
    private static readonly pb::FieldCodec<global::WS.Data.DataGlobal> _repeated_globalList_codec
        = pb::FieldCodec.ForMessage(18, global::WS.Data.DataGlobal.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataGlobal> globalList_ = new pbc::RepeatedField<global::WS.Data.DataGlobal>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataGlobal> GlobalList {
      get { return globalList_; }
    }

    /// <summary>Field number for the "letterList" field.</summary>
    public const int LetterListFieldNumber = 3;
    private static readonly pb::FieldCodec<global::WS.Data.DataLetter> _repeated_letterList_codec
        = pb::FieldCodec.ForMessage(26, global::WS.Data.DataLetter.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLetter> letterList_ = new pbc::RepeatedField<global::WS.Data.DataLetter>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLetter> LetterList {
      get { return letterList_; }
    }

    /// <summary>Field number for the "paymentList" field.</summary>
    public const int PaymentListFieldNumber = 4;
    private static readonly pb::FieldCodec<global::WS.Data.DataPayment> _repeated_paymentList_codec
        = pb::FieldCodec.ForMessage(34, global::WS.Data.DataPayment.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataPayment> paymentList_ = new pbc::RepeatedField<global::WS.Data.DataPayment>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataPayment> PaymentList {
      get { return paymentList_; }
    }

    /// <summary>Field number for the "levelWordsList" field.</summary>
    public const int LevelWordsListFieldNumber = 5;
    private static readonly pb::FieldCodec<global::WS.Data.DataLevelWords> _repeated_levelWordsList_codec
        = pb::FieldCodec.ForMessage(42, global::WS.Data.DataLevelWords.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLevelWords> levelWordsList_ = new pbc::RepeatedField<global::WS.Data.DataLevelWords>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLevelWords> LevelWordsList {
      get { return levelWordsList_; }
    }

    /// <summary>Field number for the "pieceList" field.</summary>
    public const int PieceListFieldNumber = 6;
    private static readonly pb::FieldCodec<global::WS.Data.DataPiece> _repeated_pieceList_codec
        = pb::FieldCodec.ForMessage(50, global::WS.Data.DataPiece.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataPiece> pieceList_ = new pbc::RepeatedField<global::WS.Data.DataPiece>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataPiece> PieceList {
      get { return pieceList_; }
    }

    /// <summary>Field number for the "signInList" field.</summary>
    public const int SignInListFieldNumber = 7;
    private static readonly pb::FieldCodec<global::WS.Data.DataSignIn> _repeated_signInList_codec
        = pb::FieldCodec.ForMessage(58, global::WS.Data.DataSignIn.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataSignIn> signInList_ = new pbc::RepeatedField<global::WS.Data.DataSignIn>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataSignIn> SignInList {
      get { return signInList_; }
    }

    /// <summary>Field number for the "luckyBagRandomProList" field.</summary>
    public const int LuckyBagRandomProListFieldNumber = 8;
    private static readonly pb::FieldCodec<global::WS.Data.DataLuckyBagRandomPro> _repeated_luckyBagRandomProList_codec
        = pb::FieldCodec.ForMessage(66, global::WS.Data.DataLuckyBagRandomPro.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomPro> luckyBagRandomProList_ = new pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomPro>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomPro> LuckyBagRandomProList {
      get { return luckyBagRandomProList_; }
    }

    /// <summary>Field number for the "styleList" field.</summary>
    public const int StyleListFieldNumber = 9;
    private static readonly pb::FieldCodec<global::WS.Data.DataStyle> _repeated_styleList_codec
        = pb::FieldCodec.ForMessage(74, global::WS.Data.DataStyle.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataStyle> styleList_ = new pbc::RepeatedField<global::WS.Data.DataStyle>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataStyle> StyleList {
      get { return styleList_; }
    }

    /// <summary>Field number for the "effectList" field.</summary>
    public const int EffectListFieldNumber = 10;
    private static readonly pb::FieldCodec<global::WS.Data.DataEffect> _repeated_effectList_codec
        = pb::FieldCodec.ForMessage(82, global::WS.Data.DataEffect.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataEffect> effectList_ = new pbc::RepeatedField<global::WS.Data.DataEffect>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataEffect> EffectList {
      get { return effectList_; }
    }

    /// <summary>Field number for the "levelList" field.</summary>
    public const int LevelListFieldNumber = 11;
    private static readonly pb::FieldCodec<global::WS.Data.DataLevel> _repeated_levelList_codec
        = pb::FieldCodec.ForMessage(90, global::WS.Data.DataLevel.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLevel> levelList_ = new pbc::RepeatedField<global::WS.Data.DataLevel>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLevel> LevelList {
      get { return levelList_; }
    }

    /// <summary>Field number for the "luckyBagRandomCoinList" field.</summary>
    public const int LuckyBagRandomCoinListFieldNumber = 12;
    private static readonly pb::FieldCodec<global::WS.Data.DataLuckyBagRandomCoin> _repeated_luckyBagRandomCoinList_codec
        = pb::FieldCodec.ForMessage(98, global::WS.Data.DataLuckyBagRandomCoin.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomCoin> luckyBagRandomCoinList_ = new pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomCoin>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLuckyBagRandomCoin> LuckyBagRandomCoinList {
      get { return luckyBagRandomCoinList_; }
    }

    /// <summary>Field number for the "luckyBagShowList" field.</summary>
    public const int LuckyBagShowListFieldNumber = 13;
    private static readonly pb::FieldCodec<global::WS.Data.DataLuckyBagShow> _repeated_luckyBagShowList_codec
        = pb::FieldCodec.ForMessage(106, global::WS.Data.DataLuckyBagShow.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataLuckyBagShow> luckyBagShowList_ = new pbc::RepeatedField<global::WS.Data.DataLuckyBagShow>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataLuckyBagShow> LuckyBagShowList {
      get { return luckyBagShowList_; }
    }

    /// <summary>Field number for the "toolList" field.</summary>
    public const int ToolListFieldNumber = 14;
    private static readonly pb::FieldCodec<global::WS.Data.DataTool> _repeated_toolList_codec
        = pb::FieldCodec.ForMessage(114, global::WS.Data.DataTool.Parser);
    private readonly pbc::RepeatedField<global::WS.Data.DataTool> toolList_ = new pbc::RepeatedField<global::WS.Data.DataTool>();
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public pbc::RepeatedField<global::WS.Data.DataTool> ToolList {
      get { return toolList_; }
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override bool Equals(object other) {
      return Equals(other as Constance);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public bool Equals(Constance other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if(!luckyBagUserTypeList_.Equals(other.luckyBagUserTypeList_)) return false;
      if(!globalList_.Equals(other.globalList_)) return false;
      if(!letterList_.Equals(other.letterList_)) return false;
      if(!paymentList_.Equals(other.paymentList_)) return false;
      if(!levelWordsList_.Equals(other.levelWordsList_)) return false;
      if(!pieceList_.Equals(other.pieceList_)) return false;
      if(!signInList_.Equals(other.signInList_)) return false;
      if(!luckyBagRandomProList_.Equals(other.luckyBagRandomProList_)) return false;
      if(!styleList_.Equals(other.styleList_)) return false;
      if(!effectList_.Equals(other.effectList_)) return false;
      if(!levelList_.Equals(other.levelList_)) return false;
      if(!luckyBagRandomCoinList_.Equals(other.luckyBagRandomCoinList_)) return false;
      if(!luckyBagShowList_.Equals(other.luckyBagShowList_)) return false;
      if(!toolList_.Equals(other.toolList_)) return false;
      return true;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override int GetHashCode() {
      int hash = 1;
      hash ^= luckyBagUserTypeList_.GetHashCode();
      hash ^= globalList_.GetHashCode();
      hash ^= letterList_.GetHashCode();
      hash ^= paymentList_.GetHashCode();
      hash ^= levelWordsList_.GetHashCode();
      hash ^= pieceList_.GetHashCode();
      hash ^= signInList_.GetHashCode();
      hash ^= luckyBagRandomProList_.GetHashCode();
      hash ^= styleList_.GetHashCode();
      hash ^= effectList_.GetHashCode();
      hash ^= levelList_.GetHashCode();
      hash ^= luckyBagRandomCoinList_.GetHashCode();
      hash ^= luckyBagShowList_.GetHashCode();
      hash ^= toolList_.GetHashCode();
      return hash;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public override string ToString() {
      return pb::JsonFormatter.ToDiagnosticString(this);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void WriteTo(pb::CodedOutputStream output) {
      luckyBagUserTypeList_.WriteTo(output, _repeated_luckyBagUserTypeList_codec);
      globalList_.WriteTo(output, _repeated_globalList_codec);
      letterList_.WriteTo(output, _repeated_letterList_codec);
      paymentList_.WriteTo(output, _repeated_paymentList_codec);
      levelWordsList_.WriteTo(output, _repeated_levelWordsList_codec);
      pieceList_.WriteTo(output, _repeated_pieceList_codec);
      signInList_.WriteTo(output, _repeated_signInList_codec);
      luckyBagRandomProList_.WriteTo(output, _repeated_luckyBagRandomProList_codec);
      styleList_.WriteTo(output, _repeated_styleList_codec);
      effectList_.WriteTo(output, _repeated_effectList_codec);
      levelList_.WriteTo(output, _repeated_levelList_codec);
      luckyBagRandomCoinList_.WriteTo(output, _repeated_luckyBagRandomCoinList_codec);
      luckyBagShowList_.WriteTo(output, _repeated_luckyBagShowList_codec);
      toolList_.WriteTo(output, _repeated_toolList_codec);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public int CalculateSize() {
      int size = 0;
      size += luckyBagUserTypeList_.CalculateSize(_repeated_luckyBagUserTypeList_codec);
      size += globalList_.CalculateSize(_repeated_globalList_codec);
      size += letterList_.CalculateSize(_repeated_letterList_codec);
      size += paymentList_.CalculateSize(_repeated_paymentList_codec);
      size += levelWordsList_.CalculateSize(_repeated_levelWordsList_codec);
      size += pieceList_.CalculateSize(_repeated_pieceList_codec);
      size += signInList_.CalculateSize(_repeated_signInList_codec);
      size += luckyBagRandomProList_.CalculateSize(_repeated_luckyBagRandomProList_codec);
      size += styleList_.CalculateSize(_repeated_styleList_codec);
      size += effectList_.CalculateSize(_repeated_effectList_codec);
      size += levelList_.CalculateSize(_repeated_levelList_codec);
      size += luckyBagRandomCoinList_.CalculateSize(_repeated_luckyBagRandomCoinList_codec);
      size += luckyBagShowList_.CalculateSize(_repeated_luckyBagShowList_codec);
      size += toolList_.CalculateSize(_repeated_toolList_codec);
      return size;
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void MergeFrom(Constance other) {
      if (other == null) {
        return;
      }
      luckyBagUserTypeList_.Add(other.luckyBagUserTypeList_);
      globalList_.Add(other.globalList_);
      letterList_.Add(other.letterList_);
      paymentList_.Add(other.paymentList_);
      levelWordsList_.Add(other.levelWordsList_);
      pieceList_.Add(other.pieceList_);
      signInList_.Add(other.signInList_);
      luckyBagRandomProList_.Add(other.luckyBagRandomProList_);
      styleList_.Add(other.styleList_);
      effectList_.Add(other.effectList_);
      levelList_.Add(other.levelList_);
      luckyBagRandomCoinList_.Add(other.luckyBagRandomCoinList_);
      luckyBagShowList_.Add(other.luckyBagShowList_);
      toolList_.Add(other.toolList_);
    }

    [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 10: {
            luckyBagUserTypeList_.AddEntriesFrom(input, _repeated_luckyBagUserTypeList_codec);
            break;
          }
          case 18: {
            globalList_.AddEntriesFrom(input, _repeated_globalList_codec);
            break;
          }
          case 26: {
            letterList_.AddEntriesFrom(input, _repeated_letterList_codec);
            break;
          }
          case 34: {
            paymentList_.AddEntriesFrom(input, _repeated_paymentList_codec);
            break;
          }
          case 42: {
            levelWordsList_.AddEntriesFrom(input, _repeated_levelWordsList_codec);
            break;
          }
          case 50: {
            pieceList_.AddEntriesFrom(input, _repeated_pieceList_codec);
            break;
          }
          case 58: {
            signInList_.AddEntriesFrom(input, _repeated_signInList_codec);
            break;
          }
          case 66: {
            luckyBagRandomProList_.AddEntriesFrom(input, _repeated_luckyBagRandomProList_codec);
            break;
          }
          case 74: {
            styleList_.AddEntriesFrom(input, _repeated_styleList_codec);
            break;
          }
          case 82: {
            effectList_.AddEntriesFrom(input, _repeated_effectList_codec);
            break;
          }
          case 90: {
            levelList_.AddEntriesFrom(input, _repeated_levelList_codec);
            break;
          }
          case 98: {
            luckyBagRandomCoinList_.AddEntriesFrom(input, _repeated_luckyBagRandomCoinList_codec);
            break;
          }
          case 106: {
            luckyBagShowList_.AddEntriesFrom(input, _repeated_luckyBagShowList_codec);
            break;
          }
          case 114: {
            toolList_.AddEntriesFrom(input, _repeated_toolList_codec);
            break;
          }
        }
      }
    }

  }

  #endregion

}

#endregion Designer generated code
