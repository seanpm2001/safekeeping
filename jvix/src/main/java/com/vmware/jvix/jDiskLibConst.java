/**
 *
 */
package com.vmware.jvix;

/**
 * @author mdaneri
 *
 */
public interface jDiskLibConst {

	/*
	 * jDiskLib Version
	 */
	int MAJOR_VERSION = 6;
	int MINOR_VERSION = 8;
	/**
	 *
	 */

	int VIX_OK = 0;
	/* General errors */
	int VIX_E_FAIL = 1;
	int VIX_E_OUT_OF_MEMORY = 2;
	int VIX_E_INVALID_ARG = 3;
	int VIX_E_FILE_NOT_FOUND = 4;
	int VIX_E_OBJECT_IS_BUSY = 5;
	int VIX_E_NOT_SUPPORTED = 6;
	int VIX_E_FILE_ERROR = 7;
	int VIX_E_DISK_FULL = 8;
	int VIX_E_INCORRECT_FILE_TYPE = 9;
	int VIX_E_CANCELLED = 10;
	int VIX_E_FILE_READ_ONLY = 11;
	int VIX_E_FILE_ALREADY_EXISTS = 12;
	int VIX_E_FILE_ACCESS_ERROR = 13;

	int VIX_E_REQUIRES_LARGE_FILES = 14;
	int VIX_E_FILE_ALREADY_LOCKED = 15;
	int VIX_E_NOT_SUPPORTED_ON_REMOTE_OBJECT = 20;

	int VIX_E_FILE_TOO_BIG = 21;
	int VIX_E_FILE_NAME_INVALID = 22;
	int VIX_E_ALREADY_EXISTS = 23;

	int VIX_E_BUFFER_TOOSMALL = 24;
	int VIX_E_OBJECT_NOT_FOUND = 25;
	int VIX_E_HOST_NOT_CONNECTED = 26;
	int VIX_E_INVALID_UTF8_STRING = 27;
	int VIX_E_OPERATION_ALREADY_IN_PROGRESS = 31;
	int VIX_E_UNFINISHED_JOB = 29;

	int VIX_E_NEED_KEY = 30;
	int VIX_E_LICENSE = 32;
	int VIX_E_VM_HOST_DISCONNECTED = 34;

	int VIX_E_AUTHENTICATION_FAIL = 35;
	int VIX_E_HOST_CONNECTION_LOST = 36;
	int VIX_E_DUPLICATE_NAME = 41;

	int VIX_E_ARGUMENT_TOO_BIG = 44;
	/* Handle Errors */
	int VIX_E_INVALID_HANDLE = 1000;
	int VIX_E_NOT_SUPPORTED_ON_HANDLE_TYPE = 1001;
	int VIX_E_TOO_MANY_HANDLES = 1002;
	/* XML errors */
	int VIX_E_NOT_FOUND = 2000;
	int VIX_E_TYPE_MISMATCH = 2001;
	int VIX_E_INVALID_XML = 2002;
	/* VM Control Errors */
	int VIX_E_TIMEOUT_WAITING_FOR_TOOLS = 3000;
	int VIX_E_UNRECOGNIZED_COMMAND = 3001;
	int VIX_E_OP_NOT_SUPPORTED_ON_GUEST = 3003;
	int VIX_E_PROGRAM_NOT_STARTED = 3004;
	int VIX_E_CANNOT_START_READ_ONLY_VM = 3005;
	int VIX_E_VM_NOT_RUNNING = 3006;
	int VIX_E_VM_IS_RUNNING = 3007;
	int VIX_E_CANNOT_CONNECT_TO_VM = 3008;
	int VIX_E_POWEROP_SCRIPTS_NOT_AVAILABLE = 3009;
	int VIX_E_NO_GUEST_OS_INSTALLED = 3010;
	int VIX_E_VM_INSUFFICIENT_HOST_MEMORY = 3011;
	int VIX_E_SUSPEND_ERROR = 3012;
	int VIX_E_VM_NOT_ENOUGH_CPUS = 3013;
	int VIX_E_HOST_USER_PERMISSIONS = 3014;
	int VIX_E_GUEST_USER_PERMISSIONS = 3015;
	int VIX_E_TOOLS_NOT_RUNNING = 3016;
	int VIX_E_GUEST_OPERATIONS_PROHIBITED = 3017;
	int VIX_E_ANON_GUEST_OPERATIONS_PROHIBITED = 3018;
	int VIX_E_ROOT_GUEST_OPERATIONS_PROHIBITED = 3019;

	int VIX_E_MISSING_ANON_GUEST_ACCOUNT = 3023;
	int VIX_E_CANNOT_AUTHENTICATE_WITH_GUEST = 3024;
	int VIX_E_UNRECOGNIZED_COMMAND_IN_GUEST = 3025;
	int VIX_E_CONSOLE_GUEST_OPERATIONS_PROHIBITED = 3026;
	int VIX_E_MUST_BE_CONSOLE_USER = 3027;
	int VIX_E_NOT_ALLOWED_DURING_VM_RECORDING = 3028;

	int VIX_E_NOT_ALLOWED_DURING_VM_REPLAY = 3029;
	/* VM Errors */
	int VIX_E_VM_NOT_FOUND = 4000;
	int VIX_E_NOT_SUPPORTED_FOR_VM_VERSION = 4001;
	int VIX_E_CANNOT_READ_VM_CONFIG = 4002;

	int VIX_E_TEMPLATE_VM = 4003;

	int VIX_E_VM_ALREADY_LOADED = 4004;
	int VIX_E_VM_ALREADY_UP_TO_DATE = 4006;
	/* Property Errors */
	int VIX_E_UNRECOGNIZED_PROPERTY = 6000;
	int VIX_E_INVALID_PROPERTY_VALUE = 6001;
	int VIX_E_READ_ONLY_PROPERTY = 6002;
	int VIX_E_MISSING_REQUIRED_PROPERTY = 6003;
	/* Completion Errors */
	int VIX_E_BAD_VM_INDEX = 8000;
	/* Snapshot errors */
	int VIX_E_SNAPSHOT_INVAL = 13000;
	int VIX_E_SNAPSHOT_DUMPER = 13001;
	int VIX_E_SNAPSHOT_DISKLIB = 13002;
	int VIX_E_SNAPSHOT_NOTFOUND = 13003;
	int VIX_E_SNAPSHOT_EXISTS = 13004;
	int VIX_E_SNAPSHOT_VERSION = 13005;
	int VIX_E_SNAPSHOT_NOPERM = 13006;
	int VIX_E_SNAPSHOT_CONFIG = 13007;
	int VIX_E_SNAPSHOT_NOCHANGE = 13008;
	int VIX_E_SNAPSHOT_CHECKPOINT = 13009;
	int VIX_E_SNAPSHOT_LOCKED = 13010;
	int VIX_E_SNAPSHOT_INCONSISTENT = 13011;
	int VIX_E_SNAPSHOT_NAMETOOLONG = 13012;
	int VIX_E_SNAPSHOT_VIXFILE = 13013;
	int VIX_E_SNAPSHOT_DISKLOCKED = 13014;
	int VIX_E_SNAPSHOT_DUPLICATEDDISK = 13015;

	int VIX_E_SNAPSHOT_INDEPENDENTDISK = 13016;
	int VIX_E_SNAPSHOT_NONUNIQUE_NAME = 13017;
	int VIX_E_SNAPSHOT_MEMORY_ON_INDEPENDENT_DISK = 13018;
	int VIX_E_SNAPSHOT_MAXSNAPSHOTS = 13019;
	int VIX_E_SNAPSHOT_MIN_FREE_SPACE = 13020;
	int VIX_E_SNAPSHOT_HIERARCHY_TOODEEP = 13021;
	int VIX_E_SNAPSHOT_RRSUSPEND = 13022;
	/* Host Errors */
	int VIX_E_HOST_DISK_INVALID_VALUE = 14003;
	int VIX_E_HOST_DISK_SECTORSIZE = 14004;
	int VIX_E_HOST_FILE_ERROR_EOF = 14005;
	int VIX_E_HOST_NETBLKDEV_HANDSHAKE = 14006;

	int VIX_E_HOST_SOCKET_CREATION_ERROR = 14007;
	int VIX_E_HOST_SERVER_NOT_FOUND = 14008;
	int VIX_E_HOST_NETWORK_CONN_REFUSED = 14009;
	int VIX_E_HOST_TCP_SOCKET_ERROR = 14010;
	int VIX_E_HOST_TCP_CONN_LOST = 14011;
	int VIX_E_HOST_NBD_HASHFILE_VOLUME = 14012;
	int VIX_E_HOST_NBD_HASHFILE_INIT = 14013;
	int VIX_E_HOST_SERVER_SHUTDOWN = 14014;
	int VIX_E_HOST_SERVER_NOT_AVAILABLE = 14015;

	/* Disklib errors */
	int VIX_E_DISK_INVAL = 16000;
	int VIX_E_DISK_NOINIT = 16001;
	int VIX_E_DISK_NOIO = 16002;
	int VIX_E_DISK_PARTIALCHAIN = 16003;
	int VIX_E_DISK_NEEDSREPAIR = 16006;
	int VIX_E_DISK_OUTOFRANGE = 16007;
	int VIX_E_DISK_CID_MISMATCH = 16008;
	int VIX_E_DISK_CANTSHRINK = 16009;
	int VIX_E_DISK_PARTMISMATCH = 16010;
	int VIX_E_DISK_UNSUPPORTEDDISKVERSION = 16011;
	int VIX_E_DISK_OPENPARENT = 16012;
	int VIX_E_DISK_NOTSUPPORTED = 16013;
	int VIX_E_DISK_NEEDKEY = 16014;
	int VIX_E_DISK_NOKEYOVERRIDE = 16015;
	int VIX_E_DISK_NOTENCRYPTED = 16016;
	int VIX_E_DISK_NOKEY = 16017;
	int VIX_E_DISK_INVALIDPARTITIONTABLE = 16018;
	int VIX_E_DISK_NOTNORMAL = 16019;
	int VIX_E_DISK_NOTENCDESC = 16020;
	int VIX_E_DISK_NEEDVMFS = 16022;
	int VIX_E_DISK_RAWTOOBIG = 16024;
	int VIX_E_DISK_TOOMANYOPENFILES = 16027;
	int VIX_E_DISK_TOOMANYREDO = 16028;
	int VIX_E_DISK_RAWTOOSMALL = 16029;
	int VIX_E_DISK_INVALIDCHAIN = 16030;
	int VIX_E_DISK_KEY_NOTFOUND = 16052; // metadata key is not found
	int VIX_E_DISK_SUBSYSTEM_INIT_FAIL = 16053;
	int VIX_E_DISK_INVALID_CONNECTION = 16054;
	int VIX_E_DISK_ENCODING = 16061;
	int VIX_E_DISK_CANTREPAIR = 16062;

	int VIX_E_DISK_INVALIDDISK = 16063;
	int VIX_E_DISK_NOLICENSE = 16064;

	int VIX_E_DISK_NODEVICE = 16065;
	int VIX_E_DISK_UNSUPPORTEDDEVICE = 16066;
	int VIX_E_DISK_CAPACITY_MISMATCH = 16067;
	int VIX_E_DISK_PARENT_NOTALLOWED = 16068;

	int VIX_E_DISK_ATTACH_ROOTLINK = 16069;
	/* Crypto Library Errors */
	int VIX_E_CRYPTO_UNKNOWN_ALGORITHM = 17000;
	int VIX_E_CRYPTO_BAD_BUFFER_SIZE = 17001;
	int VIX_E_CRYPTO_INVALID_OPERATION = 17002;
	int VIX_E_CRYPTO_RANDOM_DEVICE = 17003;
	int VIX_E_CRYPTO_NEED_PASSWORD = 17004;
	int VIX_E_CRYPTO_BAD_PASSWORD = 17005;

	int VIX_E_CRYPTO_NOT_IN_DICTIONARY = 17006;
	int VIX_E_CRYPTO_NO_CRYPTO = 17007;
	int VIX_E_CRYPTO_ERROR = 17008;

	int VIX_E_CRYPTO_BAD_FORMAT = 17009;
	int VIX_E_CRYPTO_LOCKED = 17010;
	int VIX_E_CRYPTO_EMPTY = 17011;
	int VIX_E_CRYPTO_KEYSAFE_LOCATOR = 17012;

	/* Remoting Errors. */
	int VIX_E_CANNOT_CONNECT_TO_HOST = 18000;

	int VIX_E_NOT_FOR_REMOTE_HOST = 18001;
	int VIX_E_INVALID_HOSTNAME_SPECIFICATION = 18002;
	/* Screen Capture Errors. */
	int VIX_E_SCREEN_CAPTURE_ERROR = 19000;
	int VIX_E_SCREEN_CAPTURE_BAD_FORMAT = 19001;
	int VIX_E_SCREEN_CAPTURE_COMPRESSION_FAIL = 19002;

	int VIX_E_SCREEN_CAPTURE_LARGE_DATA = 19003;
	/* Guest Errors */
	int VIX_E_NOT_A_FILE = 20001;
	int VIX_E_NOT_A_DIRECTORY = 20002;
	int VIX_E_NO_SUCH_PROCESS = 20003;
	int VIX_E_FILE_NAME_TOO_LONG = 20004;
	long VIX_E_OPERATION_DISABLED = 20005;
	/* Success on operation that completes asynchronously */
	int VIX_ASYNC = 25000;
	/* Async errors */
	int VIX_E_ASYNC_MIXEDMODE_UNSUPPORTED = 26000;
	/* Network Errors */
	int VIX_E_NET_HTTP_UNSUPPORTED_PROTOCOL = 30001;
	int VIX_E_NET_HTTP_URL_MALFORMAT = 30003;
	int VIX_E_NET_HTTP_COULDNT_RESOLVE_PROXY = 30005;
	int VIX_E_NET_HTTP_COULDNT_RESOLVE_HOST = 30006;
	int VIX_E_NET_HTTP_COULDNT_CONNECT = 30007;

	int VIX_E_NET_HTTP_HTTP_RETURNED_ERROR = 30022;
	int VIX_E_NET_HTTP_OPERATION_TIMEDOUT = 30028;
	int VIX_E_NET_HTTP_SSL_CONNECT_ERROR = 30035;
	int VIX_E_NET_HTTP_TOO_MANY_REDIRECTS = 30047;
	int VIX_E_NET_HTTP_TRANSFER = 30200;
	int VIX_E_NET_HTTP_SSL_SECURITY = 30201;
	int VIX_E_NET_HTTP_GENERIC = 30202;
	/* Fault Injection Codes */
	int VDDK_SAN_SERVER_CONNECT_ERROR = 0;
	int VDDK_SAN_BLKLIST_INIT_ERROR = 1;
	int VDDK_SAN_STARTIO_ERROR = 2;
	int VDDK_SAN_UNKNOWN_ADAPTER = 3;
	int VDDK_SAN_DISK_OPEN_ERROR = 4;
	int VDDK_SAN_ASYNC_READ_WRITE_ERROR = 5;

	int VDDK_SAN_READ_WRITE_ERROR = 6;
	int VDDK_HOTADD_ADDDISK_DISK_NOT_FOUND = 7;
	int VDDK_HOTADD_ADDDISK_DISK_ADD_FAILED = 8;
	int VDDK_HOTADD_REMOVEDISK_FAILED = 9;
	int VDDK_VIXDISKLIB_INIT_DISKLIB_FAILED = 10;
	int VDDK_VIXDISKLIBVIM_LOAD_DISK_BAD_KEY = 11;

	int VDDK_VIXDISKLIBVIM_BAD_TICKET = 12;
	/*
	 * VixDiskLib Open Flags
	 */
	int OPEN_UNBUFFERED = (1 << 0);
	int OPEN_SINGLE_LINK = (1 << 1);
	int OPEN_READ_ONLY = (1 << 2);
	int OPEN_COMPRESSION_ZLIB = (1 << 4);
	int OPEN_COMPRESSION_FASTLZ = (1 << 5);
	int OPEN_COMPRESSION_SKIPZ = (1 << 6);

	/*
	 * VixDiskLib xDisk Types
	 */
	int DISK_MONOLITHIC_SPARSE = 1; // monolithic file, sparse
	int DISK_MONOLITHIC_FLAT = 2; // monolithic file,
	// all space pre-allocated
	int DISK_SPLIT_SPARSE = 3; // disk split into 2GB extents,
	// sparse
	int DISK_SPLIT_FLAT = 4; // disk split into 2GB extents,

	/*
	 * VixDiskLib Hardware Versions
	 */

	// pre-allocated
	int DISK_VMFS_FLAT = 5; // ESX 3.0 and above flat disks

	int DISK_STREAM_OPTIMIZED = 6; // compressed monolithic sparse

	int DISK_UNKNOWN = 256; // unknown type

	/*
	 * VixDiskLib Adapter Types
	 */
	int ADAPTER_IDE = 1;

	int ADAPTER_SCSI_BUSLOGIC = 2;
	int ADAPTER_SCSI_LSILOGIC = 3;
	int ADAPTER_UNKNOWN = 256;
	// VMware Workstation 4.x and GSX Server 3.x
	int HWVERSION_WORKSTATION_4 = 3;

	// VMware Workstation 5.x and Server 1.x
	int HWVERSION_WORKSTATION_5 = 4;

	// VMware ESX Server 3.0
	int HWVERSION_ESX30 = HWVERSION_WORKSTATION_5;

	// VMware Workstation 6.x
	int HWVERSION_WORKSTATION_6 = 6;

	int HWVERSION_ESX4X = 7;
	int HWVERSION_ESX50 = 8;
	int HWVERSION_ESX51 = 9;
	int HWVERSION_ESX55 = 10;
	int HWVERSION_ESX60 = 11;
	int HWVERSION_ESX65 = 13;

	// Current hardware version
	int HWVERSION_CURRENT = HWVERSION_ESX65;

//	    public static final int SECTOR_SIZE = 512;

	// Default buffer size (in sectors) for read/write
	int DEFAULT_BUFSIZE = 128;

	// Minimal number of sectors per chunk
	long MIN_CHUNK_SIZE = (64 * 2); // 64K

	// Maximal number of sectors per chunk
	long MAX_CHUNK_SIZE = (64 * 2 * 1024); // 64M

	// Maximal number of chunks per query
	long MAX_CHUNK_NUMBER = (512 * 1024);
	/**
	 * Number of bytes per sector
	 */
	int SECTOR_SIZE = 512;

}
