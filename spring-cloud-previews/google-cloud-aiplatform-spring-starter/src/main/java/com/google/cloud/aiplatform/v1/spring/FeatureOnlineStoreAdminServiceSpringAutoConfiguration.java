/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient;
import com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceSettings;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link FeatureOnlineStoreAdminServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@AutoConfigureAfter(GcpContextAutoConfiguration.class)
@ConditionalOnClass(FeatureOnlineStoreAdminServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.aiplatform.v1.feature-online-store-admin-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(FeatureOnlineStoreAdminServiceSpringProperties.class)
public class FeatureOnlineStoreAdminServiceSpringAutoConfiguration {
  private final FeatureOnlineStoreAdminServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(FeatureOnlineStoreAdminServiceSpringAutoConfiguration.class);

  protected FeatureOnlineStoreAdminServiceSpringAutoConfiguration(
      FeatureOnlineStoreAdminServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Using credentials from FeatureOnlineStoreAdminService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean, corresponding to the client library's
   * default transport channel provider. If the library supports both GRPC and REST transport, and
   * the useRest property is configured, the HTTP/JSON transport provider will be used instead of
   * GRPC.
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultFeatureOnlineStoreAdminServiceTransportChannelProvider")
  public TransportChannelProvider defaultFeatureOnlineStoreAdminServiceTransportChannelProvider() {
    return FeatureOnlineStoreAdminServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a FeatureOnlineStoreAdminServiceSettings bean configured to use a
   * DefaultCredentialsProvider and the client library's default transport channel provider
   * (defaultFeatureOnlineStoreAdminServiceTransportChannelProvider()). It also configures the quota
   * project ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in FeatureOnlineStoreAdminServiceSpringProperties. Method-level properties will take precedence
   * over service-level properties if available, and client library defaults will be used if neither
   * are specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link FeatureOnlineStoreAdminServiceSettings} bean configured with {@link
   *     TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public FeatureOnlineStoreAdminServiceSettings featureOnlineStoreAdminServiceSettings(
      @Qualifier("defaultFeatureOnlineStoreAdminServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    FeatureOnlineStoreAdminServiceSettings.Builder clientSettingsBuilder =
        FeatureOnlineStoreAdminServiceSettings.newBuilder();
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          FeatureOnlineStoreAdminServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getFeatureOnlineStoreRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureOnlineStoreSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getFeatureOnlineStoreSettings()
          .setRetrySettings(getFeatureOnlineStoreRetrySettings);

      RetrySettings listFeatureOnlineStoresRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureOnlineStoresSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listFeatureOnlineStoresSettings()
          .setRetrySettings(listFeatureOnlineStoresRetrySettings);

      RetrySettings getFeatureViewRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureViewSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getFeatureViewSettings().setRetrySettings(getFeatureViewRetrySettings);

      RetrySettings listFeatureViewsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureViewsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listFeatureViewsSettings()
          .setRetrySettings(listFeatureViewsRetrySettings);

      RetrySettings syncFeatureViewRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.syncFeatureViewSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .syncFeatureViewSettings()
          .setRetrySettings(syncFeatureViewRetrySettings);

      RetrySettings getFeatureViewSyncRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureViewSyncSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getFeatureViewSyncSettings()
          .setRetrySettings(getFeatureViewSyncRetrySettings);

      RetrySettings listFeatureViewSyncsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureViewSyncsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listFeatureViewSyncsSettings()
          .setRetrySettings(listFeatureViewSyncsRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getFeatureOnlineStoreRetry = clientProperties.getGetFeatureOnlineStoreRetry();
    if (getFeatureOnlineStoreRetry != null) {
      RetrySettings getFeatureOnlineStoreRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureOnlineStoreSettings().getRetrySettings(),
              getFeatureOnlineStoreRetry);
      clientSettingsBuilder
          .getFeatureOnlineStoreSettings()
          .setRetrySettings(getFeatureOnlineStoreRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getFeatureOnlineStore from properties.");
      }
    }
    Retry listFeatureOnlineStoresRetry = clientProperties.getListFeatureOnlineStoresRetry();
    if (listFeatureOnlineStoresRetry != null) {
      RetrySettings listFeatureOnlineStoresRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureOnlineStoresSettings().getRetrySettings(),
              listFeatureOnlineStoresRetry);
      clientSettingsBuilder
          .listFeatureOnlineStoresSettings()
          .setRetrySettings(listFeatureOnlineStoresRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listFeatureOnlineStores from properties.");
      }
    }
    Retry getFeatureViewRetry = clientProperties.getGetFeatureViewRetry();
    if (getFeatureViewRetry != null) {
      RetrySettings getFeatureViewRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureViewSettings().getRetrySettings(),
              getFeatureViewRetry);
      clientSettingsBuilder.getFeatureViewSettings().setRetrySettings(getFeatureViewRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getFeatureView from properties.");
      }
    }
    Retry listFeatureViewsRetry = clientProperties.getListFeatureViewsRetry();
    if (listFeatureViewsRetry != null) {
      RetrySettings listFeatureViewsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureViewsSettings().getRetrySettings(),
              listFeatureViewsRetry);
      clientSettingsBuilder
          .listFeatureViewsSettings()
          .setRetrySettings(listFeatureViewsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listFeatureViews from properties.");
      }
    }
    Retry syncFeatureViewRetry = clientProperties.getSyncFeatureViewRetry();
    if (syncFeatureViewRetry != null) {
      RetrySettings syncFeatureViewRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.syncFeatureViewSettings().getRetrySettings(),
              syncFeatureViewRetry);
      clientSettingsBuilder
          .syncFeatureViewSettings()
          .setRetrySettings(syncFeatureViewRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for syncFeatureView from properties.");
      }
    }
    Retry getFeatureViewSyncRetry = clientProperties.getGetFeatureViewSyncRetry();
    if (getFeatureViewSyncRetry != null) {
      RetrySettings getFeatureViewSyncRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeatureViewSyncSettings().getRetrySettings(),
              getFeatureViewSyncRetry);
      clientSettingsBuilder
          .getFeatureViewSyncSettings()
          .setRetrySettings(getFeatureViewSyncRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getFeatureViewSync from properties.");
      }
    }
    Retry listFeatureViewSyncsRetry = clientProperties.getListFeatureViewSyncsRetry();
    if (listFeatureViewSyncsRetry != null) {
      RetrySettings listFeatureViewSyncsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeatureViewSyncsSettings().getRetrySettings(),
              listFeatureViewSyncsRetry);
      clientSettingsBuilder
          .listFeatureViewSyncsSettings()
          .setRetrySettings(listFeatureViewSyncsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listFeatureViewSyncs from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
      }
    }
    Retry setIamPolicyRetry = clientProperties.getSetIamPolicyRetry();
    if (setIamPolicyRetry != null) {
      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), setIamPolicyRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for setIamPolicy from properties.");
      }
    }
    Retry getIamPolicyRetry = clientProperties.getGetIamPolicyRetry();
    if (getIamPolicyRetry != null) {
      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), getIamPolicyRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIamPolicy from properties.");
      }
    }
    Retry testIamPermissionsRetry = clientProperties.getTestIamPermissionsRetry();
    if (testIamPermissionsRetry != null) {
      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(),
              testIamPermissionsRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for testIamPermissions from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a FeatureOnlineStoreAdminServiceClient bean configured with
   * FeatureOnlineStoreAdminServiceSettings.
   *
   * @param featureOnlineStoreAdminServiceSettings settings to configure an instance of client bean.
   * @return a {@link FeatureOnlineStoreAdminServiceClient} bean configured with {@link
   *     FeatureOnlineStoreAdminServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient(
      FeatureOnlineStoreAdminServiceSettings featureOnlineStoreAdminServiceSettings)
      throws IOException {
    return FeatureOnlineStoreAdminServiceClient.create(featureOnlineStoreAdminServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-feature-online-store-admin-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
