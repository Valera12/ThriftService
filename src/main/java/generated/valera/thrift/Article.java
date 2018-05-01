/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package generated.valera.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-05-01")
public class Article implements org.apache.thrift.TBase<Article, Article._Fields>, java.io.Serializable, Cloneable, Comparable<Article> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Article");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("year", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ArticleStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ArticleTupleSchemeFactory();

  public int id; // required
  public java.lang.String title; // required
  public Author author; // required
  public int year; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    TITLE((short)2, "title"),
    AUTHOR((short)3, "author"),
    YEAR((short)4, "year");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // TITLE
          return TITLE;
        case 3: // AUTHOR
          return AUTHOR;
        case 4: // YEAR
          return YEAR;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __YEAR_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Author")));
    tmpMap.put(_Fields.YEAR, new org.apache.thrift.meta_data.FieldMetaData("year", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Article.class, metaDataMap);
  }

  public Article() {
  }

  public Article(
    int id,
    java.lang.String title,
    Author author,
    int year)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.title = title;
    this.author = author;
    this.year = year;
    setYearIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Article(Article other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetAuthor()) {
      this.author = new Author(other.author);
    }
    this.year = other.year;
  }

  public Article deepCopy() {
    return new Article(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.title = null;
    this.author = null;
    setYearIsSet(false);
    this.year = 0;
  }

  public int getId() {
    return this.id;
  }

  public Article setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public java.lang.String getTitle() {
    return this.title;
  }

  public Article setTitle(java.lang.String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public Author getAuthor() {
    return this.author;
  }

  public Article setAuthor(Author author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  public int getYear() {
    return this.year;
  }

  public Article setYear(int year) {
    this.year = year;
    setYearIsSet(true);
    return this;
  }

  public void unsetYear() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  /** Returns true if field year is set (has been assigned a value) and false otherwise */
  public boolean isSetYear() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  public void setYearIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __YEAR_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((java.lang.String)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((Author)value);
      }
      break;

    case YEAR:
      if (value == null) {
        unsetYear();
      } else {
        setYear((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case TITLE:
      return getTitle();

    case AUTHOR:
      return getAuthor();

    case YEAR:
      return getYear();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case TITLE:
      return isSetTitle();
    case AUTHOR:
      return isSetAuthor();
    case YEAR:
      return isSetYear();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Article)
      return this.equals((Article)that);
    return false;
  }

  public boolean equals(Article that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_year = true;
    boolean that_present_year = true;
    if (this_present_year || that_present_year) {
      if (!(this_present_year && that_present_year))
        return false;
      if (this.year != that.year)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + ((isSetTitle()) ? 131071 : 524287);
    if (isSetTitle())
      hashCode = hashCode * 8191 + title.hashCode();

    hashCode = hashCode * 8191 + ((isSetAuthor()) ? 131071 : 524287);
    if (isSetAuthor())
      hashCode = hashCode * 8191 + author.hashCode();

    hashCode = hashCode * 8191 + year;

    return hashCode;
  }

  @Override
  public int compareTo(Article other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTitle()).compareTo(other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAuthor()).compareTo(other.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, other.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetYear()).compareTo(other.isSetYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.year, other.year);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Article(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("author:");
    if (this.author == null) {
      sb.append("null");
    } else {
      sb.append(this.author);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("year:");
    sb.append(this.year);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ArticleStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArticleStandardScheme getScheme() {
      return new ArticleStandardScheme();
    }
  }

  private static class ArticleStandardScheme extends org.apache.thrift.scheme.StandardScheme<Article> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Article struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.author = new Author();
              struct.author.read(iprot);
              struct.setAuthorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.year = iprot.readI32();
              struct.setYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Article struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.title != null) {
        oprot.writeFieldBegin(TITLE_FIELD_DESC);
        oprot.writeString(struct.title);
        oprot.writeFieldEnd();
      }
      if (struct.author != null) {
        oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
        struct.author.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(YEAR_FIELD_DESC);
      oprot.writeI32(struct.year);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ArticleTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArticleTupleScheme getScheme() {
      return new ArticleTupleScheme();
    }
  }

  private static class ArticleTupleScheme extends org.apache.thrift.scheme.TupleScheme<Article> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Article struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetTitle()) {
        optionals.set(1);
      }
      if (struct.isSetAuthor()) {
        optionals.set(2);
      }
      if (struct.isSetYear()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetTitle()) {
        oprot.writeString(struct.title);
      }
      if (struct.isSetAuthor()) {
        struct.author.write(oprot);
      }
      if (struct.isSetYear()) {
        oprot.writeI32(struct.year);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Article struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.title = iprot.readString();
        struct.setTitleIsSet(true);
      }
      if (incoming.get(2)) {
        struct.author = new Author();
        struct.author.read(iprot);
        struct.setAuthorIsSet(true);
      }
      if (incoming.get(3)) {
        struct.year = iprot.readI32();
        struct.setYearIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

