﻿//-----------------------------------------------------------
// Copyright (c) AzurePortalExtensionResourceProvider.  All rights reserved.
//-----------------------------------------------------------

namespace AzurePortalExtensionResourceProvider
{
    /// <summary>
    /// Textual codes used for the resource provider error response.
    /// Always use ToString() with this enum when generating error responses.
    /// The error code will be returned together with the error message as part of the error response.
    /// Numeric values should not be sent over the wire.
    /// </summary>
    public enum ResponseErrorCode
    {
        Invalid,
        NotFound,
        BadRequest,
        ServiceUnavailable,
        InsufficientQuota,
        InvalidQuota,
    }
}