/**
 * Copyright (C) 2013-2017 Steffen Schaefer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.docstr.gradle.plugins.gwt;

import java.io.File;
import java.util.concurrent.Callable;
import org.gradle.api.internal.IConventionAware;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.docstr.gradle.plugins.gwt.internal.GwtCompileOptionsImpl;

/**
 * Common implementation of tasks used for GWT compilation.
 */
public class AbstractGwtCompile extends AbstractGwtTask implements
    GwtCompileOptions {

  private final GwtCompileOptions options = new GwtCompileOptionsImpl();

  public AbstractGwtCompile() {
    super("com.google.gwt.dev.Compiler");
  }

  @Override
  protected void addArgs() {
    super.addArgs();

    argIfSet("-localWorkers", getLocalWorkers());
    argIfEnabled(getDraftCompile(), "-draftCompile");
    argIfEnabled(getCompileReport(), "-compileReport");
    argIfEnabled(getCompilerMetrics(), "-XcompilerMetrics");

    argIfEnabled(getValidateOnly(), "-validateOnly");
    argIfEnabled(getDisableGeneratingOnShards(), "-XdisableGeneratingOnShards");

    argIfSet("-optimize", getOptimize());
    argIfEnabled(getDisableAggressiveOptimization(),
        "-XdisableAggressiveOptimization");
    argIfEnabled(getDisableClassMetadata(), "-XdisableClassMetadata");
    argIfEnabled(getDisableCastChecking(), "-XdisableCastChecking");
    argIfEnabled(getEa(), "-ea");
    argIfEnabled(getDisableRunAsync(), "-XdisableRunAsync");
    argIfSet("-style", getStyle());
    argIfEnabled(getSoycDetailed(), "-XsoycDetailed");
    argIfEnabled(getStrict(), "-strict");
    argIfEnabled(getDisableSoycHtml(), "-XdisableSoycHtml");
    argIfSet("-XfragmentCount", getFragmentCount());
    argIfSet("-missingDepsFile", getMissingDepsFile());
    argIfSet("-Xnamespace", getNamespace());
    argOnOff(getEnforceStrictResources(), "-XenforceStrictResources",
        "-XnoenforceStrictResources");
    argOnOff(getIncrementalCompileWarnings(), "-incrementalCompileWarnings",
        "-noincrementalCompileWarnings");
    argOnOff(getOverlappingSourceWarnings(), "-overlappingSourceWarnings",
        "-nooverlappingSourceWarnings");
    argOnOff(getSaveSource(), "-saveSource", "-nosaveSource");
    argIfSet("-saveSourceOutput", getSaveSourceOutput());
    argOnOff(getClosureFormattedOutput(), "-XclosureFormattedOutput",
        "-XnoclosureFormattedOutput");
  }

  protected void configure(final GwtCompileOptions options) {
    ((IConventionAware) this).getConventionMapping()
        .map("localWorkers",
            (Callable<Integer>) () -> options.getLocalWorkers());
  }

  /** {@inheritDoc} */
  @Input
  @Override
  public Integer getLocalWorkers() {
    return options.getLocalWorkers();
  }

  /** {@inheritDoc} */
  @Override
  public void setLocalWorkers(Integer localWorkers) {
    options.setLocalWorkers(localWorkers);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDraftCompile() {
    return options.getDraftCompile();
  }

  /** {@inheritDoc} */
  @Override
  public void setDraftCompile(Boolean draftCompile) {
    options.setDraftCompile(draftCompile);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getCompileReport() {
    return options.getCompileReport();
  }

  /** {@inheritDoc} */
  @Override
  public void setCompileReport(Boolean compileReport) {
    options.setCompileReport(compileReport);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getCompilerMetrics() {
    return options.getCompilerMetrics();
  }

  /** {@inheritDoc} */
  @Override
  public void setCompilerMetrics(Boolean compilerMetrics) {
    options.setCompilerMetrics(compilerMetrics);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getValidateOnly() {
    return options.getValidateOnly();
  }

  /** {@inheritDoc} */
  @Override
  public void setValidateOnly(Boolean validateOnly) {
    options.setValidateOnly(validateOnly);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableGeneratingOnShards() {
    return options.getDisableGeneratingOnShards();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableGeneratingOnShards(Boolean disableGeneratingOnShards) {
    options.setDisableGeneratingOnShards(disableGeneratingOnShards);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Integer getOptimize() {
    return options.getOptimize();
  }

  /** {@inheritDoc} */
  @Override
  public void setOptimize(Integer optimize) {
    options.setOptimize(optimize);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableAggressiveOptimization() {
    return options.getDisableAggressiveOptimization();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableAggressiveOptimization(
      Boolean disableAggressiveOptimization) {
    options.setDisableAggressiveOptimization(disableAggressiveOptimization);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableClassMetadata() {
    return options.getDisableClassMetadata();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableClassMetadata(Boolean disableClassMetadata) {
    options.setDisableClassMetadata(disableClassMetadata);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableCastChecking() {
    return options.getDisableCastChecking();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableCastChecking(Boolean disableCastChecking) {
    options.setDisableCastChecking(disableCastChecking);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getEa() {
    return options.getEa();
  }

  /** {@inheritDoc} */
  @Override
  public void setEa(Boolean ea) {
    options.setEa(ea);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableRunAsync() {
    return options.getDisableRunAsync();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableRunAsync(Boolean disableRunAsync) {
    options.setDisableRunAsync(disableRunAsync);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Style getStyle() {
    return options.getStyle();
  }

  /** {@inheritDoc} */
  @Override
  public void setStyle(Style style) {
    options.setStyle(style);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getSoycDetailed() {
    return options.getSoycDetailed();
  }

  /** {@inheritDoc} */
  @Override
  public void setSoycDetailed(Boolean soycDetailed) {
    options.setSoycDetailed(soycDetailed);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getStrict() {
    return options.getStrict();
  }

  /** {@inheritDoc} */
  @Override
  public void setStrict(Boolean strict) {
    options.setStrict(strict);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Boolean getDisableSoycHtml() {
    return options.getDisableSoycHtml();
  }

  /** {@inheritDoc} */
  @Override
  public void setDisableSoycHtml(Boolean disableSoycHtml) {
    options.setDisableSoycHtml(disableSoycHtml);
  }

  /** {@inheritDoc} */
  @Override
  @Input
  @Optional
  public Integer getFragmentCount() {
    return options.getFragmentCount();
  }

  /** {@inheritDoc} */
  @Override
  public void setFragmentCount(Integer fragmentCount) {
    options.setFragmentCount(fragmentCount);
  }

  /** {@inheritDoc} */
  @Optional
  @InputFile
  @PathSensitive(PathSensitivity.ABSOLUTE)
  @Override
  public File getMissingDepsFile() {
    return options.getMissingDepsFile();
  }

  /** {@inheritDoc} */
  @Override
  public void setMissingDepsFile(File missingDepsFile) {
    options.setMissingDepsFile(missingDepsFile);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Namespace getNamespace() {
    return options.getNamespace();
  }

  /** {@inheritDoc} */
  @Override
  public void setNamespace(Namespace namespace) {
    options.setNamespace(namespace);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Boolean getEnforceStrictResources() {
    return options.getEnforceStrictResources();
  }

  /** {@inheritDoc} */
  @Override
  public void setEnforceStrictResources(Boolean enforceStrictResources) {
    options.setEnforceStrictResources(enforceStrictResources);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Boolean getIncrementalCompileWarnings() {
    return options.getIncrementalCompileWarnings();
  }

  /** {@inheritDoc} */
  @Override
  public void setIncrementalCompileWarnings(
      Boolean incrementalCompileWarnings) {
    options.setIncrementalCompileWarnings(incrementalCompileWarnings);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Boolean getOverlappingSourceWarnings() {
    return options.getOverlappingSourceWarnings();
  }

  /** {@inheritDoc} */
  @Override
  public void setOverlappingSourceWarnings(Boolean overlappingSourceWarnings) {
    options.setOverlappingSourceWarnings(overlappingSourceWarnings);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Boolean getSaveSource() {
    return options.getSaveSource();
  }

  /** {@inheritDoc} */
  @Override
  public void setSaveSource(Boolean saveSource) {
    options.setSaveSource(saveSource);
  }

  /** {@inheritDoc} */
  @Optional
  @OutputDirectory
  @Override
  public File getSaveSourceOutput() {
    return options.getSaveSourceOutput();
  }

  /** {@inheritDoc} */
  @Override
  public void setSaveSourceOutput(File saveSourceOutput) {
    options.setSaveSourceOutput(saveSourceOutput);
  }

  /** {@inheritDoc} */
  @Optional
  @Input
  @Override
  public Boolean getClosureFormattedOutput() {
    return options.getClosureFormattedOutput();
  }

  /** {@inheritDoc} */
  @Override
  public void setClosureFormattedOutput(Boolean closureFormattedOutput) {
    options.setClosureFormattedOutput(closureFormattedOutput);
  }
}
